package com.adriandevs.androidmaster1.todoapp.ui.features.todo.view.adapter.task

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.adriandevs.androidmaster1.databinding.ItemTodoTaskBinding

class TasksAdapter(private val tasks: List<Task>, private val onTaskSelected: (Int) -> Unit) :
    RecyclerView.Adapter<TasksViewHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): TasksViewHolder {
        val binding =
            ItemTodoTaskBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return TasksViewHolder(binding)
    }

    override fun onBindViewHolder(holder: TasksViewHolder, position: Int) {
        holder.render(tasks[position])
        holder.itemView.setOnClickListener {  onTaskSelected(position) }
    }

    override fun getItemCount() = tasks.size

}
