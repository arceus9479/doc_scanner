package com.coding.meet.docscannerapp.data.models

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import java.util.Date

/**
 * Created 08-04-2024 at 01:01 pm
 */

@Entity(tableName = "pdfTable")
data class PdfEntity(
    @PrimaryKey(autoGenerate = false)
    @ColumnInfo(name="pdfId")
    val id:String,
    val name:String,
    val size: String,
    val lastModifiedTime : Date
)
