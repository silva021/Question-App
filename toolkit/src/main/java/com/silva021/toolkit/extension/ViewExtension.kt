package com.silva021.toolkit.extension

import android.view.View
import android.widget.ImageView
import androidx.annotation.DrawableRes

fun ImageView.load(@DrawableRes drawableId: Int) = this.setImageDrawable(resources.getDrawable(drawableId))

fun View.visible() {
    this.visibility = View.VISIBLE
}

fun View.gone() {
    this.visibility = View.GONE
}