package com.example.techalchemytask.helpers

import java.text.DateFormat
import java.text.SimpleDateFormat
import java.util.*

object DateUtil {
    /**
     * Gets the date time in standard format.
     */
    fun getStandardTime(timeStamp: String): String {
        val outputFormat: DateFormat = SimpleDateFormat("EEE, dd MMM yyyy HH:mm", Locale.US)
        val inputFormat: DateFormat = SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss'Z'", Locale.US)
        val date: Date = inputFormat.parse(timeStamp)

        return outputFormat.format(date)
    }
}