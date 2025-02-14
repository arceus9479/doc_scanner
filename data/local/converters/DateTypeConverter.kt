package com.coding.meet.docscannerapp.data.local.converters

import androidx.room.TypeConverter
import java.util.Date

/**
 * Created 18-04-2024 at 02:52 pm
 */

class DateTypeConverter {

    @TypeConverter
    fun fromTimestamp(value:Long):Date{
        return Date(value)
    }

    @TypeConverter
    fun dateToTimestamp(date: Date): Long {
        return date.time
    }
}