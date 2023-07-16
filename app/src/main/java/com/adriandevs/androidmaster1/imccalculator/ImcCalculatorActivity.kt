package com.adriandevs.androidmaster1.imccalculator

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.core.content.ContextCompat
import com.adriandevs.androidmaster1.R
import com.adriandevs.androidmaster1.databinding.ActivityImcCalculatorBinding

class ImcCalculatorActivity : AppCompatActivity() {
    private lateinit var binding: ActivityImcCalculatorBinding
    private var isMaleSelected: Boolean = true
    private var isFemaleSelected: Boolean = false
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityImcCalculatorBinding.inflate(layoutInflater)
        setContentView(binding.root)
        initComponents()
        initListeners()
        setGenderColor()
    }


    private fun initComponents() {
        binding.btnMale
        binding.btnFemale
    }

    private fun initListeners() {
        binding.btnMale.setOnClickListener {
            isMaleSelected = true
            isFemaleSelected = false
            setGenderColor()
        }

        binding.btnFemale.setOnClickListener {
            isMaleSelected = false
            isFemaleSelected = true
            setGenderColor()
        }
    }

    private fun setGenderColor() {

        val maleBackgroundColor = getBackgroundColor(isMaleSelected)
        val femaleBackgroundColor = getBackgroundColor(isFemaleSelected)

        binding.btnMale.setCardBackgroundColor(maleBackgroundColor)
        binding.btnFemale.setCardBackgroundColor(femaleBackgroundColor)

    }

    private fun getBackgroundColor(isSelectedComponent: Boolean) : Int{
        val colorReference = if (isSelectedComponent) {
            R.color.background_component_selected
        } else {
            R.color.background_component
        }

       return ContextCompat.getColor(this, colorReference)
    }
}