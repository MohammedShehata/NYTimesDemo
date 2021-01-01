package com.sh.nytimes.utils

import java.text.SimpleDateFormat
import java.util.*
import java.util.concurrent.TimeUnit

object DateUtils {
    private val SERVER_DATE_FORMAT = "yyyy-MM-dd HH:mm:ss"

    fun getDiffDaysToToday(stringDate: String): Int {

        val sdf = SimpleDateFormat(SERVER_DATE_FORMAT)
        val date = sdf.parse(stringDate)

        val diff = Date().time - date!!.time
        return TimeUnit.DAYS.convert(diff, TimeUnit.MILLISECONDS).toInt()
    }
}