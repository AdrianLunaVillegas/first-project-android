package com.adriandevs.androidmaster1.firstapp.common

import android.content.Context
import android.util.AttributeSet
import android.view.LayoutInflater
import com.adriandevs.androidmaster1.databinding.CardViewHeightBinding
import com.google.android.material.card.MaterialCardView

class HeightCardView(
    context: Context, attributeSet: AttributeSet
) : MaterialCardView(context, attributeSet){

    private val binding = CardViewHeightBinding.inflate(
        LayoutInflater.from(context),this, true
    )
}
