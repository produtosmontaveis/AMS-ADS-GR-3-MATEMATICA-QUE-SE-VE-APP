package com.produtos.montaveis.data

import com.produtos.montaveis.model.Challenge
import com.produtos.montaveis.model.Formula
import com.produtos.montaveis.model.Student

object MockData {

    val student = Student(
        1, "Gustavo", 0, 40, mutableListOf(
            Challenge(
                Formula(
                    1,
                    "Quadrado da soma",
                    "https://raw.githubusercontent.com/produtosmontaveis/AMS-ADS-GR-3-DOC/main/assets/models/Quadrado%20soma.png"
                ),
                0.0
            ),
            Challenge(
                Formula(
                    2,
                    "Quadrado da diferença",
                    "https://raw.githubusercontent.com/produtosmontaveis/AMS-ADS-GR-3-DOC/main/assets/models/Quadrado%20da%20diferen%C3%A7a.png"
                ),
                0.0
            ),
            Challenge(
                Formula(
                    3,
                    "Diferença de quadrados",
                    "https://raw.githubusercontent.com/produtosmontaveis/AMS-ADS-GR-3-DOC/main/assets/models/Diferen%C3%A7a%20de%20quadrados.png"
                ),
                0.0
            ),
            Challenge(
                Formula(
                    4,
                    "Cubo da soma",
                    "https://raw.githubusercontent.com/produtosmontaveis/AMS-ADS-GR-3-DOC/main/assets/models/Cubo%20da%20soma.png"
                ),
                0.0
            ),
            Challenge(
                Formula(
                    5,
                    "Soma de cubos",
                    "https://raw.githubusercontent.com/produtosmontaveis/AMS-ADS-GR-3-DOC/main/assets/models/Soma%20de%20cubos.png"
                ),
                0.0
            ),
            Challenge(
                Formula(
                    6,
                    "Cubo da diferença",
                    "https://raw.githubusercontent.com/produtosmontaveis/AMS-ADS-GR-3-DOC/main/assets/models/Cubo%20da%20diferen%C3%A7a.png"
                ),
                0.0
            ),
            Challenge(
                Formula(
                    7,
                    "Diferença de cubos",
                    "https://raw.githubusercontent.com/produtosmontaveis/AMS-ADS-GR-3-DOC/main/assets/models/Diferen%C3%A7a%20de%20cubos.png"
                ),
                0.0
            )
        )
    )
}