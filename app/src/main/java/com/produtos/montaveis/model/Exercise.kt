package com.produtos.montaveis.model

data class Exercise(
    val id: Long,
    val title: String,
    val description: String,
    val answer: String,
    val points: Int
)

data class ExerciseResponse(
    val studentId: Long,
    val exerciseId: Long,
    val studentAnswer: String,
    val finishDate: String
)