package com.adriandevs.androidmaster1.todoapp.ui.features.todo.view.adapter.task

import android.content.res.ColorStateList
import android.graphics.Paint
import androidx.core.content.ContextCompat
import androidx.recyclerview.widget.RecyclerView
import com.adriandevs.androidmaster1.R
import com.adriandevs.androidmaster1.databinding.ItemTodoTaskBinding
import com.adriandevs.androidmaster1.todoapp.ui.features.todo.view.adapter.categories.TaskCategory

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

            cbTask.isChecked = task.isSelected
            tvTask.text = task.name

            val color = when (task.category) {
                TaskCategory.Business -> R.color.todo_business_category
                TaskCategory.Other -> R.color.todo_other_category
                TaskCategory.Personal -> R.color.todo_personal_category
                TaskCategory.Tasks -> R.color.todo_business_category
            }

            cbTask.buttonTintList = ColorStateList.valueOf(
                ContextCompat.getColor(cbTask.context, color)
            )
        }
    }
}