package com.example.millioner




data class Question(
    val id: Int,
    val description: String="",
    val answer_1: String="",
    val answer_2: String="",
    val answer_3: String="",
    val answer_4: String="",
    val answer_right: String="",
    val cost: Int=0
)
