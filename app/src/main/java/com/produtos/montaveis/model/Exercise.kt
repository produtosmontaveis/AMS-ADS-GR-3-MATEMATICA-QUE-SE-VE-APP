package com.produtos.montaveis.model

data class Exercise(
    val id: Long,
    val title: String,
    val description: String,
    val answer: String,
    val points: Int,
    val imgUrl: String?,
    val options: List<String>?,
    var studentAnswer: StudentAnswer? = null
)

data class StudentAnswer(
    val studentId: Long,
    val answer: String,
    val finishDate: String
)