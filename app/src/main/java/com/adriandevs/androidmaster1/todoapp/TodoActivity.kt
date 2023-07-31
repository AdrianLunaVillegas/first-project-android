package com.adriandevs.androidmaster1.todoapp

import android.app.Dialog
import android.os.Bundle
import android.view.LayoutInflater
import android.widget.Button
import android.widget.RadioButton
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import com.adriandevs.androidmaster1.R
import com.adriandevs.androidmaster1.databinding.ActivityTodoBinding
import com.adriandevs.androidmaster1.databinding.DialogTaskBinding
import com.adriandevs.androidmaster1.todoapp.TaskCategory.Business
import com.adriandevs.androidmaster1.todoapp.TaskCategory.Other
import com.adriandevs.androidmaster1.todoapp.TaskCategory.Personal
import com.adriandevs.androidmaster1.todoapp.TaskCategory.Tasks
import com.google.android.material.floatingactionbutton.FloatingActionButton

class TodoActivity : AppCompatActivity() {
    private lateinit var binding: ActivityTodoBinding

    private val categories = listOf(
        Business,
        Personal,
        Tasks,
        Other
    )

    private val tasks = mutableListOf(
        Task("TestBusiness", Business),
        Task("TestPersonal", Personal),
        Task("TestOther", Other)
    )
    private lateinit var categoriesAdapter: CategoriesAdapter
    private lateinit var taskAdapter: TasksAdapter
    private lateinit var fabAddTask: FloatingActionButton

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityTodoBinding.inflate(layoutInflater)
        setContentView(binding.root)
        initUI()
        initListeners()
    }

    private fun initListeners() {
        binding.fabAddTask.setOnClickListener { showDialog() }
    }

    private fun showDialog() {
        binding.apply {
            val dialog = Dialog(this@TodoActivity)
            val dialogBinding = DialogTaskBinding.inflate(layoutInflater)
            dialog.setContentView(dialogBinding.root)

            val buttonAddTask = dialogBinding.buttonAddTask
            val editTextTask = dialogBinding.editTextTask
            val radioGroupCategories = dialogBinding.radioGroupCategories

            buttonAddTask.setOnClickListener {
                val selectedId = radioGroupCategories.checkedRadioButtonId
                val selectedRadioButton: RadioButton =
                    radioGroupCategories.findViewById(selectedId) //how do i access selectedId without fincviewById?//////////////
                val currentCategory: TaskCategory = when (selectedRadioButton.text) {
                    "Business" -> Business
                    "Personal" -> Personal
                    else -> Other
                }

                tasks.add(Task(editTextTask.text.toString(), currentCategory))

            }

            dialog.show()
        }
    }
    private fun initUI() {
        binding.apply {
            categoriesAdapter = CategoriesAdapter(categories)
            rvCategories.layoutManager =
                LinearLayoutManager(this@TodoActivity, LinearLayoutManager.HORIZONTAL, false)
            rvCategories.adapter = categoriesAdapter

            taskAdapter = TasksAdapter(tasks)
            rvTasks.layoutManager = LinearLayoutManager(this@TodoActivity)
            rvTasks.adapter = taskAdapter
        }
    }
}