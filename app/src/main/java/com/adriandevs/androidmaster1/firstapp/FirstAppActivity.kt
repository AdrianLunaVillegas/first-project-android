package com.adriandevs.androidmaster1.firstapp

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.adriandevs.androidmaster1.databinding.ActivityFirstAppBinding
import com.adriandevs.androidmaster1.firstapp.common.KeyConstants.ExtraName

class FirstAppActivity : AppCompatActivity() {
    private lateinit var binding: ActivityFirstAppBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityFirstAppBinding.inflate(layoutInflater)
        setContentView(binding.root)
        configBtnStart()
    }

    private fun configBtnStart() {
        binding.btnStart.setOnClickListener {
            val name = binding.etName.text.toString()
            if (name.isNotEmpty()) {///////////////// modificar para que aparte de que no este vacio, tenga que sewr obligatoriamente una string y no numeros!
                val intent = Intent(this, ResultActivity::class.java)
                intent.putExtra(ExtraName, name)
                startActivity(intent)
            }
        }
    }
}
