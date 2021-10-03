package com.example.millioner

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase

@Database(entities = arrayOf(Test::class,Question::class), version = 1,)
abstract class MillionerDatabase : RoomDatabase() {
    abstract fun testDao(): TestDao
    abstract fun QuestionDao():QuestionDao
    companion object{
        private var INSTANCE: MillionerDatabase? = null
        fun getInstance(context: Context): MillionerDatabase {
            if (INSTANCE == null) {
                INSTANCE = Room.databaseBuilder(
                    context,
                    MillionerDatabase::class.java,
                    "millioner_db")
                    .build()
            }
            return INSTANCE as MillionerDatabase
        }
    }
}
