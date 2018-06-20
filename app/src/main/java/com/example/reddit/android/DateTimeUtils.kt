package com.example.reddit.android

import android.text.format.DateUtils
import java.util.*

object DateTimeUtils {

    fun formatDuration(time: Long): String {
        val milliseconds = time - System.currentTimeMillis()
        val positiveValue = Math.abs(milliseconds)
        val now = Date().time

        if (positiveValue > DateUtils.YEAR_IN_MILLIS) {
            return DateUtils.getRelativeTimeSpanString(milliseconds + now, now, DateUtils.YEAR_IN_MILLIS, DateUtils.FORMAT_ABBREV_RELATIVE).toString()
        } else if (positiveValue > DateUtils.WEEK_IN_MILLIS) {
            return DateUtils.getRelativeTimeSpanString(milliseconds + now, now, DateUtils.WEEK_IN_MILLIS, DateUtils.FORMAT_ABBREV_RELATIVE).toString()
        } else if (positiveValue > DateUtils.DAY_IN_MILLIS) {
            return DateUtils.getRelativeTimeSpanString(milliseconds + now, now, DateUtils.DAY_IN_MILLIS, DateUtils.FORMAT_ABBREV_RELATIVE).toString()
        } else if (positiveValue > DateUtils.HOUR_IN_MILLIS) {
            return DateUtils.getRelativeTimeSpanString(milliseconds + now, now, DateUtils.HOUR_IN_MILLIS, DateUtils.FORMAT_ABBREV_RELATIVE).toString()
        } else if (positiveValue > DateUtils.MINUTE_IN_MILLIS) {
            return DateUtils.getRelativeTimeSpanString(milliseconds + now, now, DateUtils.MINUTE_IN_MILLIS, DateUtils.FORMAT_ABBREV_RELATIVE).toString()
        }

        return DateUtils.getRelativeTimeSpanString(milliseconds + now, now, DateUtils.SECOND_IN_MILLIS, DateUtils.FORMAT_ABBREV_RELATIVE).toString()

    }
}