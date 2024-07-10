package com.example.todolist

import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.lifecycle.ViewModelProvider
import com.example.todolist.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity()
{

    private lateinit var binding: ActivityMainBinding
    private lateinit var taskViewModel: TaskViewModel


    override fun onCreate(savedInstanceState: Bundle?)
    {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        taskViewModel = ViewModelProvider(this).get(TaskViewModel::class.java)
        binding.newtaskbutton.setOnClickListener {
            NewTaskSheet().show(supportFragmentManager,"newTaskTag")
        }

        taskViewModel.name.observe(this){
            binding.taskname.text = String.format("Task Name: %s", it)

        }
        taskViewModel.desc.observe(this){
            binding.taskdescription.text = String.format("Task Description: %s", it)
        }

    }
}