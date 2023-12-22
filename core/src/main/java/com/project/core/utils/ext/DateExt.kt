package com.project.core.utils.ext

import android.annotation.SuppressLint
import timber.log.Timber
import java.text.ParseException
import java.text.SimpleDateFormat
import java.util.TimeZone


@SuppressLint("SimpleDateFormat")
fun String?.formatDate(targetFormat: String = "yyyy-MM-dd HH:mm:ss"): String {
    val dateString = this ?: ""

    return try {
        val sourceFormat = SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss'Z'").apply {
            timeZone = TimeZone.getTimeZone("UTC")
        }
        val destFormat = SimpleDateFormat(targetFormat)
        val convertedDate = sourceFormat.parse(dateString) ?: return dateString

        return destFormat.format(convertedDate) ?: dateString
    }catch (e: ParseException){
        Timber.d(e)
        dateString
    }
}