package com.project.core.utils.ext

import android.annotation.SuppressLint
import timber.log.Timber
import java.text.ParseException
import java.text.SimpleDateFormat
import java.util.TimeZone


@SuppressLint("SimpleDateFormat")
fun String.formatDate(targetFormat: String = "yyyy-MM-dd HH:mm:ss"): String {
    return try {
        val sourceFormat = SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss'Z'").apply {
            timeZone = TimeZone.getTimeZone("UTC")
        }
        val destFormat = SimpleDateFormat(targetFormat)
        val convertedDate = sourceFormat.parse(this) ?: return this

        return destFormat.format(convertedDate) ?: this
    }catch (e: ParseException){
        Timber.d(e)
        this
    }
}