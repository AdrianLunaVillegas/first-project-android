package com.adriandevs.androidmaster1.firstapp

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.adriandevs.androidmaster1.databinding.ActivityFirstAppBinding
import com.adriandevs.androidmaster1.firstapp.common.KeyConstants.ExtraName

class FirstAppActivity : AppCompatActivity() {
    private var binding: ActivityFirstAppBinding? = null


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityFirstAppBinding.inflate(layoutInflater)
        binding?.let{
            setContentView(it.root)
            configBtnStart()
        }
    }

    private fun configBtnStart() {
        binding?.apply {
            btnStart.setOnClickListener {
                val name = etName.text.toString()
                if (name.isNotEmpty()) {
                    val intent = Intent(this@FirstAppActivity, ResultActivity::class.java)
                    intent.putExtra(ExtraName, name)
                    startActivity(intent)
                }
            }
        }
    }
}
