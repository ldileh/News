package com.example.core.utils.ext

import android.widget.EditText

fun String?.safe() = this ?: ""

fun EditText.value() = this.text.toString().trim()