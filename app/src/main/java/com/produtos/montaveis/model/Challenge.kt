package com.produtos.montaveis.model

data class Challenge(
    val formula: Formula,
    var progressStatus: Double? = 0.0,
    val startDateTime: String? = null,
    val finishDateTime: String? = null
)
