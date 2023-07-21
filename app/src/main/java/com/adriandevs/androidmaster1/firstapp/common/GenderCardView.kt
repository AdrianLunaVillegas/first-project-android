package com.adriandevs.androidmaster1.firstapp.common

import android.content.Context
import android.util.AttributeSet
import android.view.LayoutInflater
import android.widget.ImageView
import android.widget.TextView
import com.adriandevs.androidmaster1.R
import com.google.android.material.card.MaterialCardView

class GenderCardView(
    context: Context, attributeSet: AttributeSet
) : MaterialCardView(context, attributeSet) {
    //private lateinit var binding: MaterialCardView como trabajo con Binding?////////////////////

    private val imageView: ImageView
    private val textView: TextView

    init {
        LayoutInflater.from(context).inflate(R.layout.card_view_gender, this)

        imageView = findViewById(R.id.gMale)
        textView = findViewById((R.id.tvMale))

        val attrsArray = context.obtainStyledAttributes(attributeSet, R.styleable.GenderCardView)


        val customImage = attrsArray.getResourceId(R.styleable.GenderCardView_customImage, 0)
        val customText = attrsArray.getString(R.styleable.GenderCardView_customText)

        imageView.setImageResource(customImage)
        textView.text = customText

        attrsArray.recycle()

    }
}