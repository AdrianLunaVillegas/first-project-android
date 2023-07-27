package com.adriandevs.androidmaster1.todoapp

import androidx.recyclerview.widget.RecyclerView
import com.adriandevs.androidmaster1.databinding.ItemTodoTaskBinding

class TasksViewHolder(binding: ItemTodoTaskBinding) :
    RecyclerView.ViewHolder(binding.root) {

    private val viewBinding = binding
    fun render(task: Task) {
        viewBinding.tvTask.text = task.name
    }
}