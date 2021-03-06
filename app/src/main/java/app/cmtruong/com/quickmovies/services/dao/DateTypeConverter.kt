package app.cmtruong.com.quickmovies.services.dao

import android.arch.persistence.room.TypeConverter
import java.util.*

/**
 * @author Davide Truong
 * @version 1.0
 * @since October 29th, 2018
 */
class DateTypeConverter {

    /**
     * convert the data from Timestamps to date value
     */
    @TypeConverter
    fun fromTimestamp(value: Long?): Date? {
        return if (value == null) null else Date(value)
    }

    /**
     * convert the data from date type to timestamp
     */
    @TypeConverter
    fun dateToTimestamp(date: Date?): Long? {
        return date?.time
    }
}