package com.example.lab_3

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class TasksAdapter(private val toDoList: MutableList<Task>) : RecyclerView.Adapter<TasksAdapter.TasksViewHolder>() {

    override fun getItemCount(): Int {
        return toDoList.size
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): TasksViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.tasks_item, parent, false)
        return TasksViewHolder(view)
    }

    override fun onBindViewHolder(holder: TasksViewHolder, position: Int) {
        val task = toDoList[position]
        holder.titleTextView.text = task.title
        holder.timeTextView.text = task.time

        holder.doneButton.setOnClickListener {
            toDoList.removeAt(position)
            notifyItemRemoved(position)
            notifyItemRangeChanged(position, toDoList.size)
        }
    }

    class TasksViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val titleTextView: TextView = itemView.findViewById(R.id.task_title)
        val timeTextView: TextView = itemView.findViewById(R.id.task_time)
        val doneButton: Button = itemView.findViewById(R.id.done_button)
    }
}
