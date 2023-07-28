package com.adriandevs.androidmaster1.todoapp.ui.features.todo.view.adapter.categories

import androidx.core.content.ContextCompat
import androidx.recyclerview.widget.RecyclerView
import com.adriandevs.androidmaster1.R
import com.adriandevs.androidmaster1.databinding.ItemTaskCategoryBinding

class CategoriesViewHolder(binding: ItemTaskCategoryBinding) :
    RecyclerView.ViewHolder(binding.root) {
    private val viewBinding = binding

    fun render(taskCategory: TaskCategory) {
        viewBinding.apply {

            when (taskCategory) {
                TaskCategory.Business -> {
                    tvCategoryName.text = root.context.getString(R.string.todo_dialog_category_business)
                    divider.setBackgroundColor(
                        ContextCompat.getColor(divider.context, R.color.todo_business_category)
                    )
                }

                TaskCategory.Other -> {
                    tvCategoryName.text = root.context.getString(R.string.todo_dialog_category_other)
                    divider.setBackgroundColor(
                        ContextCompat.getColor(divider.context, R.color.todo_other_category)
                    )
                }

                TaskCategory.Personal -> {
                    tvCategoryName.text = root.context.getString(R.string.todo_dialog_category_Personal)
                    divider.setBackgroundColor(
                        ContextCompat.getColor(divider.context, R.color.todo_personal_category)
                    )
                }

                TaskCategory.Tasks -> {
                    tvCategoryName.text = root.context.getString(R.string.todo_tasks)
                    divider.setBackgroundColor(
                        ContextCompat.getColor(divider.context, R.color.todo_tasks_category)
                    )
                }
            }
        }
    }
}