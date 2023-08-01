package com.adriandevs.androidmaster1.todoapp.ui.features.todo.view.adapter.task

import com.adriandevs.androidmaster1.todoapp.ui.features.todo.view.adapter.categories.TaskCategory

data class Task (val name: String, val category: TaskCategory, var isSelected:Boolean = false)
