package com.produtos.montaveis.model

data class Challenge(
    val formula: Formula,
    var progressStatus: Double? = 0.0,
    val startDate: String? = null,
    val finishDate: String? = null,
    val badgeUrl: String
)
