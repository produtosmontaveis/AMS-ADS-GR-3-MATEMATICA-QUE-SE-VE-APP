package com.produtos.montaveis.model

data class Challenge(
    val studentId: StudentId,
    val formula: Formula,
    val progressStatus: Double,
    val startDate: String? = null,
    val finishDate: String? = null
)

data class StudentId(val studentId: Long)
