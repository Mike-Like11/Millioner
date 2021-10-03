package com.example.millioner

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import kotlinx.coroutines.flow.Flow

@Dao
interface TestDao {
    @Query("SELECT * FROM test_table ORDER BY date ASC")
    fun getAlphabetizedWords(): List<Test>

    @Insert(onConflict = OnConflictStrategy.IGNORE)
    suspend fun insert(test: Test)

    @Query("DELETE FROM test_table")
    suspend fun deleteAll()
}