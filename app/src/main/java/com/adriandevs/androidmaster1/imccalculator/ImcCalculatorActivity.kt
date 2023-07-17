package com.adriandevs.androidmaster1.imccalculator

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.TextView
import androidx.cardview.widget.CardView
import androidx.core.content.ContextCompat
import com.adriandevs.androidmaster1.R
import com.adriandevs.androidmaster1.databinding.ActivityImcCalculatorBinding
import com.google.android.material.slider.RangeSlider
import java.text.DecimalFormat

class ImcCalculatorActivity : AppCompatActivity() {
    private lateinit var binding: ActivityImcCalculatorBinding
    private var isMaleSelected: Boolean = true
    private var isFemaleSelected: Boolean = false

    private lateinit var btnMale: CardView
    private lateinit var btnFemale: CardView
    private lateinit var tvHeight: TextView
    private lateinit var rsHeight: RangeSlider


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityImcCalculatorBinding.inflate(layoutInflater)
        setContentView(binding.root)
        initialize()
    }

    private fun initialize() {
        initComponents()
        initListeners()
        setGenderColor()
    }

    private fun initComponents() {
        btnMale = binding.btnMale
        btnFemale = binding.btnFemale
        tvHeight = binding.tvHeight
        rsHeight = binding.rsHeight
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
        rsHeight.addOnChangeListener { _, value, _ ->
            val df = DecimalFormat("#.##")
            val result = df.format(value)
            tvHeight.text = "$result cm"
        }
    }

    private fun setGenderColor() {

        val maleBackgroundColor = getBackgroundColor(isMaleSelected)
        val femaleBackgroundColor = getBackgroundColor(isFemaleSelected)

        binding.btnMale.setCardBackgroundColor(maleBackgroundColor)
        binding.btnFemale.setCardBackgroundColor(femaleBackgroundColor)

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