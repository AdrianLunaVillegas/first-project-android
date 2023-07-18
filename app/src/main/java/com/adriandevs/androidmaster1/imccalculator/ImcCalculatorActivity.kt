package com.adriandevs.androidmaster1.imccalculator

import android.content.Intent
import android.os.Bundle
import android.util.Log
import androidx.appcompat.app.AppCompatActivity
import androidx.core.content.ContextCompat
import com.adriandevs.androidmaster1.R
import com.adriandevs.androidmaster1.databinding.ActivityImcCalculatorBinding
import com.adriandevs.androidmaster1.firstapp.common.KeyConstants.IMC_KEY
import com.adriandevs.androidmaster1.firstapp.common.ResultIMCActivity
import java.text.DecimalFormat

class ImcCalculatorActivity : AppCompatActivity() {
    private lateinit var binding: ActivityImcCalculatorBinding
    private var isMaleSelected: Boolean = true
    private var isFemaleSelected: Boolean = false
    private var currentWeight: Int = 80
    private var currentAge: Int = 30
    private var currentHeight: Int = 120
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityImcCalculatorBinding.inflate(layoutInflater)
        setContentView(binding.root)
        initialize()
    }

    private fun initialize() {
        initListeners()
        setGenderColor()
        setWeight()
        setAge()
        calculateIMC()

    }


    private fun initListeners() {
        binding.apply {

            btnMale.setOnClickListener {
                isMaleSelected = true
                isFemaleSelected = false
                setGenderColor()
            }

            btnFemale.setOnClickListener {
                isMaleSelected = false
                isFemaleSelected = true
                setGenderColor()
            }
            rsHeight.addOnChangeListener { _, value, _ ->

                val df = DecimalFormat("#.##")
                currentHeight = df.format(value).toInt()
                tvHeight.text = "$currentHeight cm"
            }

            btnPlusWeight.setOnClickListener {
                currentWeight += 1
                setWeight()
            }
            btnSubtractWeight.setOnClickListener {
                currentWeight -= 1
                setWeight()
            }
            btnPlusAge.setOnClickListener {
                currentAge += 1
                setAge()
            }
            btnSubtractAge.setOnClickListener {
                currentAge -= 1
                setAge()
            }
            btnCalculate.setOnClickListener {
                 val result = calculateIMC()
                navigateToResult(result)

            }
        }
    }

    private fun navigateToResult(result: Double) {
        val intent = Intent(this, ResultIMCActivity::class.java)
        intent.putExtra(IMC_KEY, result)
        startActivity(intent)
    }

    private fun calculateIMC():Double{
        val df = DecimalFormat("#.##")
        val imc = currentWeight / ((currentHeight.toDouble() / 100 * currentHeight.toDouble() / 100))
        return df.format(imc).toDouble()
    }

    private fun setWeight() {
        binding.tvWeight.text = currentWeight.toString()
    }

    private fun setAge() {
        binding.tvAge.text = currentAge.toString()
    }

    private fun setGenderColor() {

        val maleBackgroundColor = getBackgroundColor(isMaleSelected)
        val femaleBackgroundColor = getBackgroundColor(isFemaleSelected)

        binding.apply {
            btnMale.setCardBackgroundColor(maleBackgroundColor)
            btnFemale.setCardBackgroundColor(femaleBackgroundColor)
        }
    }

    private fun getBackgroundColor(isSelectedComponent: Boolean): Int {
        val colorReference = if (isSelectedComponent) {
            R.color.background_component_selected
        } else {
            R.color.background_component
        }

        return ContextCompat.getColor(this, colorReference)
    }

}



