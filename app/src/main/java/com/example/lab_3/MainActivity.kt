package com.example.lab_3

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val recyclerView: RecyclerView = findViewById(R.id.recycler_view)
        recyclerView.layoutManager = LinearLayoutManager(this)

        val toDoList = mutableListOf(
            Task("Сходить в магазин", "12:00"),
            Task("Сделать практику по андроиду", "14:00"),
            Task("Приготовить покушать", "17:00"),
            Task("Сходить на тренировку", "19:00")
        )

        recyclerView.adapter = TasksAdapter(toDoList)
    }
}
