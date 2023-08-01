package com.adriandevs.androidmaster1.firstapp

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.adriandevs.androidmaster1.databinding.ActivityMenuBinding
import com.adriandevs.androidmaster1.imccalculator.ImcCalculatorActivity
import com.adriandevs.androidmaster1.todoapp.ui.features.todo.TodoActivity

class MenuActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMenuBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMenuBinding.inflate(layoutInflater)
        setContentView(binding.root)
        navigateToSaludApp()
        navigateTobtnImcApp()
        navigateToTodoApp()
    }

    private fun navigateToTodoApp() {
        binding.btnTODOApp.setOnClickListener {
            val intent = Intent(this, TodoActivity::class.java)
            startActivity(intent)
        }

    }

    private fun navigateToSaludApp() {
        binding.btnSaludApp.setOnClickListener {
            val intent = Intent(this, FirstAppActivity::class.java)
            startActivity(intent)
        }

    }

    private fun navigateTobtnImcApp() {
        binding.btnIMCApp.setOnClickListener {
            val intent = Intent(this, ImcCalculatorActivity::class.java)
            startActivity(intent)
        }

    }
}