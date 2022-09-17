package com.blockgemini.domain.utils

import java.text.SimpleDateFormat
import java.util.*

object Utils {

    fun dateFormat(date: Long): String {
        val pattern = "yyyy-MM-dd"
        val simpleDateFormat = SimpleDateFormat(pattern, Locale.ENGLISH)
        return simpleDateFormat.format(Date(date))
    }
}