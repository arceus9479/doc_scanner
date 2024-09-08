package com.coding.meet.docscannerapp.data.local

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import androidx.room.TypeConverters
import com.coding.meet.docscannerapp.data.local.converters.DateTypeConverter
import com.coding.meet.docscannerapp.data.local.dao.PdfDao
import com.coding.meet.docscannerapp.data.models.PdfEntity

/**
 * Created 18-04-2024 at 02:43 pm
 */

@Database(
    entities = [PdfEntity::class], version = 1, exportSchema = false
)
@TypeConverters(DateTypeConverter::class)
abstract class PdfDatabase : RoomDatabase() {
    abstract val pdfDao : PdfDao

    companion object{

        @Volatile
        private var INSTANCES : PdfDatabase? = null

        fun getInstance(context:Context): PdfDatabase{
            synchronized(this){
                return INSTANCES ?: Room.databaseBuilder(
                    context.applicationContext,
                    PdfDatabase::class.java,
                    "pdf_db"
                ).build().also {
                    INSTANCES = it
                }
            }
        }
    }
}