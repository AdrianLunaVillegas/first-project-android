package com.adriandevs.androidmaster1.firstapp.common

import android.content.Context
import android.util.AttributeSet
import android.view.LayoutInflater
import com.adriandevs.androidmaster1.R
import com.adriandevs.androidmaster1.databinding.CardViewGenderBinding
import com.google.android.material.card.MaterialCardView

class GenderCardView(
    context: Context, attributeSet: AttributeSet
) : MaterialCardView(context, attributeSet) {

    private val binding = CardViewGenderBinding.inflate(
        LayoutInflater.from(context), this, true
    )

    init {

        val attrsArray = context.obtainStyledAttributes(attributeSet, R.styleable.GenderCardView)
        val customImage = attrsArray.getResourceId(R.styleable.GenderCardView_customImage, 0)
        val customText = attrsArray.getString(R.styleable.GenderCardView_customText)
        binding.apply {
            gMale.setImageResource(customImage)
            tvMale.text = customText
        }

        attrsArray.recycle()

    }
}