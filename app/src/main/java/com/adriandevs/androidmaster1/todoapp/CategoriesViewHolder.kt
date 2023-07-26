package com.adriandevs.androidmaster1.todoapp

import androidx.core.content.ContextCompat
import androidx.recyclerview.widget.RecyclerView
import com.adriandevs.androidmaster1.R
import com.adriandevs.androidmaster1.databinding.ItemTaskCategoryBinding

class CategoriesViewHolder(binding: ItemTaskCategoryBinding) :
    RecyclerView.ViewHolder(binding.root) {
    private val viewBinding = binding

    fun render(taskCategory: TaskCategory) {
        viewBinding.apply {
            tvCategoryName.text = "EXEMPLE"

            when (taskCategory) {
                TaskCategory.Business -> {
                    tvCategoryName.text =
                        "Negocios"
                    divider.setBackgroundColor(
                        ContextCompat.getColor(divider.context, R.color.todo_business_category)
                    )
                }

                TaskCategory.Other -> {
                    tvCategoryName.text = "Otros"
                    divider.setBackgroundColor(
                        ContextCompat.getColor(divider.context, R.color.todo_other_category)
                    )
                }

                TaskCategory.Personal -> {
                    tvCategoryName.text = "Personal"
                    divider.setBackgroundColor(
                        ContextCompat.getColor(divider.context, R.color.todo_personal_category)
                    )
                }
            }
        }
    }
}