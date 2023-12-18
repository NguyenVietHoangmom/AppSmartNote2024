package com.example.appsmartnote2024

import android.widget.ImageView

fun ImageView.setImageBasedOnCondition(condition: Boolean, trueImageResId: Int, falseImageResId: Int) {
    if (condition) {
        setImageResource(trueImageResId)
    } else {
        setImageResource(falseImageResId)
    }
}