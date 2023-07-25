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
//////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
    private val binding = CardViewGenderBinding.inflate( // porque aqui es VAL y en la firstActivity es VAR?
        LayoutInflater.from(context), this, true//because here it is VAL and in the firstActivity it is VAR?
    )

    init {

        val attrsArray = context.obtainStyledAttributes(attributeSet, R.styleable.GenderCardView)
        val customImage = attrsArray.getResourceId(R.styleable.GenderCardView_customImageGender, 0)
        val customText = attrsArray.getString(R.styleable.GenderCardView_customTextGender) //Why is id not put at the end of getString?/////////////////////
        initData(customImage, customText)
        attrsArray.recycle()
    }

    private fun initData(customImage: Int, customText: String?) {
        binding.apply {
            genderImage.setImageResource(customImage)
            textViewGender.text = customText
        }
    }
}

////testing if it doesn't mess it up and this commit is uploaded and I delete the previous one/////probando si no la lio y se sube este commit y borro el anterior