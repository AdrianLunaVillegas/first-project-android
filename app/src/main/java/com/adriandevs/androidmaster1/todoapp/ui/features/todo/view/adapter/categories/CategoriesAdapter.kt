package com.adriandevs.androidmaster1.todoapp.ui.features.todo.view.adapter.categories

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.adriandevs.androidmaster1.databinding.ItemTaskCategoryBinding

class CategoriesAdapter(private val categories: List<TaskCategory>) :
    RecyclerView.Adapter<CategoriesViewHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CategoriesViewHolder {
        val binding =
            ItemTaskCategoryBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return CategoriesViewHolder(binding)
    }
    override fun onBindViewHolder(holder: CategoriesViewHolder, position: Int) {
        holder.render(categories[position])
    }
    override fun getItemCount(): Int = categories.size
}