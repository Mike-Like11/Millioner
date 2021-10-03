package com.example.millioner

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import androidx.room.Room
import java.util.*

@Entity(tableName = "test_table")
data class Test(
    @PrimaryKey(autoGenerate = true) val id: Int,
    @ColumnInfo(name = "name") val name: String,
    @ColumnInfo(name = "date") val date: String = Date().toString()
)
