package com.adriandevs.androidmaster1.todoapp.ui.features.todo.view.adapter.task

import android.graphics.Paint
import androidx.recyclerview.widget.RecyclerView
import com.adriandevs.androidmaster1.databinding.ItemTodoTaskBinding

class TasksViewHolder(binding: ItemTodoTaskBinding) :
    RecyclerView.ViewHolder(binding.root) {

    private val viewBinding = binding
    fun render(task: Task) {
        viewBinding.apply {

            if (task.isSelected) {
                tvTask.paintFlags = tvTask.paintFlags or Paint.STRIKE_THRU_TEXT_FLAG
            } else {
                tvTask.paintFlags = tvTask.paintFlags and Paint.STRIKE_THRU_TEXT_FLAG.inv()
            }
            tvTask.text = task.name
        }
    }
}