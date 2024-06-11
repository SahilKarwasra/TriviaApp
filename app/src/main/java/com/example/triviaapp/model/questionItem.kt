package com.example.triviaapp.model

data class questionItem(
    val answer: String,
    val category: String,
    val choices: List<String>,
    val question: String
)