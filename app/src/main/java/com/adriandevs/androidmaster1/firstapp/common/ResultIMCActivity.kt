package com.adriandevs.androidmaster1.firstapp.common

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.adriandevs.androidmaster1.databinding.ActivityResultImcBinding
import com.adriandevs.androidmaster1.firstapp.common.KeyConstants.IMC_KEY

class ResultIMCActivity: AppCompatActivity() {
    private lateinit var binding: ActivityResultImcBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityResultImcBinding.inflate(layoutInflater)
        setContentView(binding.root)
        val result:Double = intent.extras?.getDouble(IMC_KEY) ?: -1.0
    }
}