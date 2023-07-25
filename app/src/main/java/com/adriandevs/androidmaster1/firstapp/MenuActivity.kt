package com.adriandevs.androidmaster1.firstapp

import android.annotation.SuppressLint
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import com.adriandevs.androidmaster1.R
import com.adriandevs.androidmaster1.databinding.ActivityMenuBinding
import com.adriandevs.androidmaster1.imccalculator.ImcCalculatorActivity

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

    private fun navigateToTodoApp(){
        binding.btnTODOApp.setOnClickListener {
           // val intent = Intent(this, )
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