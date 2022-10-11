package com.produtos.montaveis.data

import com.produtos.montaveis.model.Challenge
import com.produtos.montaveis.model.Formula

object ChallengeData {

    val challenges: List<Challenge> = listOf(
        Challenge(
            1,
            Formula(1, "Quadrado da soma"),
            75.0
        ),
        Challenge(
            1,
            Formula(2, "Quadrado da diferença"),
        33.3
        ),
        Challenge(
            1,
            Formula(3, "Diferença de quadrados")
        ),
        Challenge(
            1,
            Formula(4, "Cubo da soma")
        ),
        Challenge(
            1,
            Formula(5, "Soma de cubos")
        ),
        Challenge(
            1,
            Formula(6, "Cubo da diferença")
        ),
        Challenge(
            1,
            Formula(7, "Diferença de cubos")
        ),
    )
}