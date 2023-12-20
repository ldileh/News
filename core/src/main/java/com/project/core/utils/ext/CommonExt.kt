package com.project.core.utils.ext

import android.widget.EditText

fun String?.safe() = this ?: ""

fun Int?.safe() = this ?: 0

fun EditText.value() = this.text.toString().trim()