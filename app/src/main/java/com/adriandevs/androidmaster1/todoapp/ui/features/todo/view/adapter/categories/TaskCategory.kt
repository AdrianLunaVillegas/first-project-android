package com.adriandevs.androidmaster1.todoapp.ui.features.todo.view.adapter.categories

sealed class TaskCategory {
    object Personal: TaskCategory()
    object Business: TaskCategory()
    object Tasks: TaskCategory()
    object Other: TaskCategory()

}