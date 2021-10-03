package com.example.millioner

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.ForeignKey
import androidx.room.ForeignKey.CASCADE
import androidx.room.PrimaryKey
import java.util.*

@Entity(tableName = "question_table",
    foreignKeys = [
        ForeignKey(entity = Question::class,
            parentColumns = ["id"],
            childColumns = ["id_test"],
            onDelete = CASCADE)]
)
data class Question(
    @PrimaryKey(autoGenerate = true) val id: Int,
    @ColumnInfo(name = "id_test") val id_test: Int,
    @ColumnInfo(name = "description") val description: String,
    @ColumnInfo(name = "answer_1") val answer_1: String,
    @ColumnInfo(name = "answer_2") val answer_2: String,
    @ColumnInfo(name = "answer_3") val answer_3: String,
    @ColumnInfo(name = "answer_4") val answer_4: String,
    @ColumnInfo(name = "answer_right") val answer_right: String,
    @ColumnInfo(name = "cost") val cost: Int
)
