package com.adriandevs.androidmaster1.todoapp.ui.features.todo

import android.app.Dialog
import android.os.Bundle
import android.view.ViewGroup
import android.widget.RadioButton
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import com.adriandevs.androidmaster1.R
import com.adriandevs.androidmaster1.databinding.ActivityTodoBinding
import com.adriandevs.androidmaster1.databinding.DialogTaskBinding
import com.adriandevs.androidmaster1.todoapp.ui.features.todo.view.adapter.categories.CategoriesAdapter
import com.adriandevs.androidmaster1.todoapp.ui.features.todo.view.adapter.categories.TaskCategory
import com.adriandevs.androidmaster1.todoapp.ui.features.todo.view.adapter.categories.TaskCategory.Business
import com.adriandevs.androidmaster1.todoapp.ui.features.todo.view.adapter.categories.TaskCategory.Other
import com.adriandevs.androidmaster1.todoapp.ui.features.todo.view.adapter.categories.TaskCategory.Personal
import com.adriandevs.androidmaster1.todoapp.ui.features.todo.view.adapter.categories.TaskCategory.Tasks
import com.adriandevs.androidmaster1.todoapp.ui.features.todo.view.adapter.task.Task
import com.adriandevs.androidmaster1.todoapp.ui.features.todo.view.adapter.task.TasksAdapter

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
    private var categoriesAdapter: CategoriesAdapter? = null
    private var taskAdapter: TasksAdapter? = null

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
            dialog.window?.setLayout(
                ViewGroup.LayoutParams.MATCH_PARENT,
                ViewGroup.LayoutParams.WRAP_CONTENT
            )

            dialogBinding.apply {
                buttonAddTask.setOnClickListener {
                    val currentTask = editTextTask.text.toString()
                    if (currentTask.isNotEmpty()) {
                        val selectedId = radioGroupCategories.checkedRadioButtonId
                        val selectedRadioButton: RadioButton = root.findViewById(selectedId)
                        val currentCategory: TaskCategory = when (selectedRadioButton.text) {
                            getString(R.string.todo_dialog_category_business) -> Business
                            getString(R.string.todo_dialog_category_Personal) -> Personal
                            else -> Other
                        }
                        tasks.add(Task(currentTask, currentCategory))
                        updateTasks()
                        dialog.hide()
                    }
                }
                dialog.show()
            }
        }
    }

    private fun initUI() {
        binding.apply {
            categoriesAdapter =
                CategoriesAdapter(categories) { position -> updateCategories(position) }
            rvCategories.layoutManager =
                LinearLayoutManager(this@TodoActivity, LinearLayoutManager.HORIZONTAL, false)
            rvCategories.adapter = categoriesAdapter

            taskAdapter = TasksAdapter(tasks) { position -> onItemSelected(position) }
            rvTasks.layoutManager = LinearLayoutManager(this@TodoActivity)
            rvTasks.adapter = taskAdapter
        }
    }

    private fun onItemSelected(position: Int) {
        tasks[position].isSelected = !tasks[position].isSelected
        updateTasks()
    }

    private fun updateCategories(position: Int) {
        categories[position].isSelected = !categories[position].isSelected
        categoriesAdapter?.notifyItemChanged(position)
        updateTasks()
    }

    private fun updateTasks() {
        val selectedCategories: List<TaskCategory> = categories.filter { it.isSelected }
        val newTasks = tasks.filter { selectedCategories.contains(it.category) }
        taskAdapter?.tasks = newTasks
        taskAdapter?.notifyDataSetChanged()
    }
}