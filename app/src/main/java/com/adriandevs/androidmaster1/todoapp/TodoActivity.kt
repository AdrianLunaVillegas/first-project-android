package com.adriandevs.androidmaster1.todoapp

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import com.adriandevs.androidmaster1.databinding.ActivityTodoBinding

class TodoActivity : AppCompatActivity() {
    private lateinit var binding: ActivityTodoBinding

    private val categories = listOf(
        TaskCategory.Business,
        TaskCategory.Personal,
        TaskCategory.Other
    )
    private lateinit var categoriesAdapter: CategoriesAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityTodoBinding.inflate(layoutInflater)
        setContentView(binding.root)
        initUI()
    }

    private fun initUI() {
        binding.apply {
            categoriesAdapter = CategoriesAdapter(categories)
            rvCategories.layoutManager =
                LinearLayoutManager(this@TodoActivity, LinearLayoutManager.HORIZONTAL, false)
            rvCategories.adapter = categoriesAdapter
        }
    }
}