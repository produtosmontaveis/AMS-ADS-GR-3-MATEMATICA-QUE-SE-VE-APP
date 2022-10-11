package com.produtos.montaveis.model

import java.text.NumberFormat

data class Challenge(
    val studentId: Int,
    val formula: Formula,
    val progressStatus: Double = 0.0,
    val startDate: String? = null,
    val finishDate: String? = null
)

fun Challenge.getFormattedProgressStatus(): String {
    val percentageFormat = NumberFormat.getPercentInstance()
    percentageFormat.minimumFractionDigits = 2
    return percentageFormat.format(progressStatus)
}