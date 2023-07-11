package com.adriandevs.androidmaster1.firstapp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.TextView
import com.adriandevs.androidmaster1.R
import com.adriandevs.androidmaster1.databinding.ActivityResultBinding
import com.adriandevs.androidmaster1.firstapp.common.KeyConstants.ExtraName

class ResultActivity : AppCompatActivity() {
    private lateinit var binding: ActivityResultBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityResultBinding.inflate(layoutInflater)
        setContentView(binding.root)
        val tvResult : TextView = binding.tvResult
        val name:String =  intent.extras?.getString(ExtraName).orEmpty()
        tvResult.text = "Hola $name"
    }
}