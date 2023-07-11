package com.adriandevs.androidmaster1.imccalculator

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.adriandevs.androidmaster1.R
import com.adriandevs.androidmaster1.databinding.ActivityImcCalculatorBinding

class ImcCalculatorActivity : AppCompatActivity() {
    private lateinit var binding: ActivityImcCalculatorBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityImcCalculatorBinding.inflate(layoutInflater)
        setContentView(binding.root)
    }
}