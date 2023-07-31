package com.adriandevs.androidmaster1.todoapp

sealed class TaskCategory {
    object Personal: TaskCategory()
    object Business: TaskCategory()
    object Tasks: TaskCategory()
    object Other: TaskCategory()

}