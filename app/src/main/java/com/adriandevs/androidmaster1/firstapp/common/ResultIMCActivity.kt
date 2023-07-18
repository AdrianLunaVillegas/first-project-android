package com.adriandevs.androidmaster1.firstapp.common

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.core.content.ContextCompat
import com.adriandevs.androidmaster1.R
import com.adriandevs.androidmaster1.databinding.ActivityResultImcBinding
import com.adriandevs.androidmaster1.firstapp.common.KeyConstants.IMC_KEY
import com.adriandevs.androidmaster1.imccalculator.ImcCalculatorActivity

class ResultIMCActivity : AppCompatActivity() {
    private lateinit var binding: ActivityResultImcBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityResultImcBinding.inflate(layoutInflater)
        setContentView(binding.root)
        val result: Double = intent.extras?.getDouble(IMC_KEY) ?: -1.0
        initUI(result)
        initListeners()
    }

    private fun initUI(result: Double) {
        binding.apply {
            tvIMC.text = result.toString()
            when (result) {
                in 0.00..18.50 -> {// under weight
                    tvResult.text = getString(R.string.title_under_weight)
                    tvResult.setTextColor(ContextCompat.getColor(this@ResultIMCActivity, R.color.under_weight))
                    tvDescription.text = getString(R.string.description_under_weight)
                }

                in 18.51..24.99 -> { // normal weight
                    tvResult.text = getString(R.string.title_normal_weight)
                    tvResult.setTextColor(ContextCompat.getColor(this@ResultIMCActivity, R.color.normal_weight))
                    tvDescription.text = getString(R.string.description_normal_weight)
                }

                in 25.00..29.99 -> { //overWeight
                    tvResult.text = getString(R.string.title_over_weight)
                    tvResult.setTextColor(ContextCompat.getColor(this@ResultIMCActivity, R.color.over_weight))
                    tvDescription.text = getString(R.string.description_over_weight)
                }

                in 30.00..99.00 -> {// obesity
                    tvResult.text = getString(R.string.title_obese_weight)
                    tvResult.setTextColor(ContextCompat.getColor(this@ResultIMCActivity, R.color.obese))
                    tvDescription.text = getString(R.string.description_obese_weight)
                }

                else -> {//error
                    tvIMC.text = getString(R.string.error)
                    tvResult.text = getString(R.string.error)
                    tvDescription.text = getString(R.string.error)
                }
            }
        }

    }

    private fun initListeners() {
        binding.btnRecalculate.setOnClickListener {
            val intent = Intent(this, ImcCalculatorActivity::class.java)
            startActivity(intent) // si en vez de crear un INTENT utilizo un onBackPressed la pantalla anterior no se resetea y guarda los datos altura/peso anteriores
        }
    }
}