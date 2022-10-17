package com.produtos.montaveis.data

import com.produtos.montaveis.model.Challenge
import com.produtos.montaveis.model.Formula
import com.produtos.montaveis.model.Student
import com.produtos.montaveis.model.StudentId

object ChallengeData {

    val challenges: List<Challenge> = listOf(
        Challenge(
            StudentId(1),
            Formula(
                1,
                "Quadrado da soma",
                "https://raw.githubusercontent.com/produtosmontaveis/produtosmontaveis.github.io/main/assets/images/960.jpg"
            ),
            75.0
        ),
        Challenge(
            StudentId(1),
            Formula(
                1,
                "Quadrado da diferença",
                "https://raw.githubusercontent.com/produtosmontaveis/produtosmontaveis.github.io/main/assets/images/960.jpg"
            ),
            33.3
        ),
        Challenge(
            StudentId(1),
            Formula(
                1,
                "Diferença de quadrados",
                "https://raw.githubusercontent.com/produtosmontaveis/produtosmontaveis.github.io/main/assets/images/960.jpg"
            ),
            0.0
        ),
        Challenge(
            StudentId(1),
            Formula(
                1,
                "Cubo da soma",
                "https://raw.githubusercontent.com/produtosmontaveis/produtosmontaveis.github.io/main/assets/images/960.jpg"
            ),
            0.0
        ),
        Challenge(

            StudentId(1),
            Formula(
                1,
                "Soma de cubos",
                "https://raw.githubusercontent.com/produtosmontaveis/produtosmontaveis.github.io/main/assets/images/960.jpg"
            ),
            0.0
        ),
        Challenge(
            StudentId(1),
            Formula(
                1,
                "Cubo da diferença",
                "https://raw.githubusercontent.com/produtosmontaveis/produtosmontaveis.github.io/main/assets/images/960.jpg"
            ),
            0.0
        ),
        Challenge(
            StudentId(1),
            Formula(
                1,
                "Diferença de cubos",
                "https://raw.githubusercontent.com/produtosmontaveis/produtosmontaveis.github.io/main/assets/images/960.jpg"
            ),
            0.0
        ),
    )

    val student = Student(1, "Gustavo", 2, 40)
}