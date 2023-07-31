package com.adriandevs.androidmaster1.todoapp

data class Task (val name: String, val category: TaskCategory, var isSelected:Boolean = false)
