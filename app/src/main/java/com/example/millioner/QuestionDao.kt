package com.example.millioner

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query

@Dao
interface QuestionDao {
    @Query("SELECT * FROM question_table ORDER BY id ASC")
    fun getAlphabetizedWords(): List<Question>

    @Insert(onConflict = OnConflictStrategy.IGNORE)
    suspend fun insert(test: Test)

    @Query("DELETE FROM question_table")
    suspend fun deleteAll()
}