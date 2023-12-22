package com.project.core.utils.ext

import android.view.View

fun View.show() {
    visibility = View.VISIBLE
}

fun View.hide() {
    visibility = View.GONE
}

fun View.isShow() = visibility == View.VISIBLE

fun View.isHide() = visibility == View.GONE