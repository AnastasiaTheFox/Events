package com.akomissarova.dazntest.utils

import java.text.SimpleDateFormat
import java.util.Locale

class TimeFormatter {
    private val formatter = SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss.SSS'Z'", Locale.getDefault())
    private val newFormat = SimpleDateFormat("dd.MM.yyyy HH:mm", Locale.getDefault())

    fun convertDate(rawDate: String) = formatter.parse(rawDate)?.let { newFormat.format(it) }
}
