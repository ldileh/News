package com.project.core.utils.ext

import android.widget.EditText

fun String?.safe(default: String = "") = this ?: default

fun Int?.safe() = this ?: 0

fun EditText.value() = this.text.toString().trim()