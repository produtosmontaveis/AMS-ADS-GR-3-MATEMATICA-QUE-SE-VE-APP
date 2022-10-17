package com.produtos.montaveis.model

data class Challenge(
    val formula: Formula,
    val progressStatus: Double,
    val startDate: String? = null,
    val finishDate: String? = null
)
