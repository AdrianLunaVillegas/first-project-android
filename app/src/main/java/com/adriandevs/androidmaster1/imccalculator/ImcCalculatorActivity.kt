package com.adriandevs.androidmaster1.imccalculator

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.core.content.ContextCompat
import com.adriandevs.androidmaster1.R
import com.adriandevs.androidmaster1.databinding.ActivityImcCalculatorBinding
import java.text.DecimalFormat

class ImcCalculatorActivity : AppCompatActivity() {
    private lateinit var binding: ActivityImcCalculatorBinding
    private var isMaleSelected: Boolean = true
    private var isFemaleSelected: Boolean = false
    private var currentWeight: Int = 50
    private var currentAge: Int = 30

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
        calculateImc()
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
                val result = df.format(value)
                val text = "$result cm"
                tvHeight.text = text
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
                calculateImc
            }
        }
    }

    private calculateImc(){

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


