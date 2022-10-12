package com.produtos.montaveis.model

import java.text.NumberFormat

data class Challenge(
    val studentId: StudentId,
    val formula: Formula,
    val progressStatus: Double,
    val startDate: String? = null,
    val finishDate: String? = null
)

data class StudentId(val studentId: Long)

fun Challenge.getFormattedProgressStatus(): String {
    val percentageFormat = NumberFormat.getPercentInstance()
    percentageFormat.minimumFractionDigits = 2
    return percentageFormat.format(progressStatus)
}