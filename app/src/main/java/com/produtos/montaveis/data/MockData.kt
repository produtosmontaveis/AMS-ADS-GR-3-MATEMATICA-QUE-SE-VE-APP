package com.produtos.montaveis.data

import com.produtos.montaveis.model.Challenge
import com.produtos.montaveis.model.Exercise
import com.produtos.montaveis.model.Formula
import com.produtos.montaveis.model.Student

object MockData {

    var student = Student(
        1, "Aluno", 0, 0, mutableListOf(
            Challenge(
                Formula(
                    1,
                    name = "Quadrado da soma",
                    imgUrl = "https://raw.githubusercontent.com/produtosmontaveis/AMS-ADS-GR-3-DOC/main/assets/models/Quadrado%20soma.png",
                    badgeImageUrl = "https://raw.githubusercontent.com/produtosmontaveis/produtosmontaveis.github.io/main/assets/images/960.jpg"
                ),
                progressStatus = 0.0,
            ),
            Challenge(
                Formula(
                    2,
                    "Quadrado da diferença",
                    "https://raw.githubusercontent.com/produtosmontaveis/AMS-ADS-GR-3-DOC/main/assets/models/Quadrado%20da%20diferen%C3%A7a.png",
                    badgeImageUrl = "https://raw.githubusercontent.com/produtosmontaveis/produtosmontaveis.github.io/main/assets/images/960.jpg"
                ),

                0.0
            ),
            Challenge(
                Formula(
                    3,
                    "Diferença de quadrados",
                    "https://raw.githubusercontent.com/produtosmontaveis/AMS-ADS-GR-3-DOC/main/assets/models/Diferen%C3%A7a%20de%20quadrados.png",
                    badgeImageUrl = "https://raw.githubusercontent.com/produtosmontaveis/produtosmontaveis.github.io/main/assets/images/960.jpg"
                ),
                0.0,
            ),
            Challenge(
                Formula(
                    4,
                    "Cubo da soma",
                    "https://raw.githubusercontent.com/produtosmontaveis/AMS-ADS-GR-3-DOC/main/assets/models/Cubo%20da%20soma.png",
                    badgeImageUrl = "https://raw.githubusercontent.com/produtosmontaveis/produtosmontaveis.github.io/main/assets/images/960.jpg",
                ),
                0.0,
            ),
            Challenge(
                Formula(
                    5,
                    "Soma de cubos",
                    "https://raw.githubusercontent.com/produtosmontaveis/AMS-ADS-GR-3-DOC/main/assets/models/Soma%20de%20cubos.png",
                    badgeImageUrl = "https://raw.githubusercontent.com/produtosmontaveis/produtosmontaveis.github.io/main/assets/images/960.jpg",
                ),
                0.0,
            ),
            Challenge(
                Formula(
                    6,
                    "Cubo da diferença",
                    "https://raw.githubusercontent.com/produtosmontaveis/AMS-ADS-GR-3-DOC/main/assets/models/Cubo%20da%20diferen%C3%A7a.png",
                    badgeImageUrl = "https://raw.githubusercontent.com/produtosmontaveis/produtosmontaveis.github.io/main/assets/images/960.jpg",
                ),
                0.0,
            ),
            Challenge(
                Formula(
                    7,
                    "Diferença de cubos",
                    "https://raw.githubusercontent.com/produtosmontaveis/AMS-ADS-GR-3-DOC/main/assets/models/Diferen%C3%A7a%20de%20cubos.png",
                    badgeImageUrl = "https://raw.githubusercontent.com/produtosmontaveis/produtosmontaveis.github.io/main/assets/images/960.jpg",
                ),
                0.0,
            )
        )
    )

    var exercises = listOf(
        Exercise(
            1,
            "Exercício 1",
            "Lorem ipsum dolor sit amet, consectetur adipiscing elit. Praesent ullamcorper volutpat mauris. Sed tincidunt purus id nibh ornare luctus. Suspendisse ornare odio pharetra.",
            "A",
            30,
            null,
            listOf("A", "B", "C", "D"),
        ),
        Exercise(
            2,
            "Exercício 2",
            "Consectetur adipiscing elit. Praesent ullamcorper volutpat mauris. Sed tincidunt purus id nibh ornare luctus. Suspendisse ornare odio pharetra.",
            "A",
            30,
            null,
                    listOf("A", "B", "C", "D"),
        ),
        Exercise(
            3,
            "Exercício 3",
            "Praesent ullamcorper volutpat mauris. Sed tincidunt purus id nibh ornare luctus. Suspendisse ornare odio pharetra, lorem ipsum dolor sit amet",
            "C",
            40,
            null,
            listOf("A", "B", "C", "D"),
        ),
        Exercise(
            4,
            "Exercício 4",
            "Suspendisse ornare odio pharetra, lorem ipsum dolor sit amet, consectetur adipiscing elit. Praesent ullamcorper volutpat mauris. Sed tincidunt purus id nibh ornare luctus.",
            "E",
            30,
            null,
            listOf("A", "B", "C", "D"),
        ),
        Exercise(
            5,
            "Exercício 5",
            "Sed tincidunt purus id nibh ornare luctus, lorem ipsum dolor sit amet, consectetur adipiscing elit. Praesent ullamcorper volutpat mauris. Sed tincidunt purus id nibh ornare luctus. Suspendisse ornare odio pharetra",
            "E",
            50,
            null,
            listOf("A", "B", "C", "D"),
        ),
        Exercise(
            6,
            "Exercício 6",
            "Ullamcorper volutpat mauris. Suspendisse ornare odio. Lorem ipsum dolor sit amet, consectetur adipiscing elit. Praesent ullamcorper volutpat mauris. Sed tincidunt purus id nibh ornare luctus. Suspendisse ornare odio pharetra",
            "B",
            30,
            null,
            listOf("A", "B", "C", "D"),
        ),
        Exercise(
            7,
            "Exercício 7",
            "Tincidunt purus id nibh ornare luctus. Suspendisse lorem ipsum dolor sit amet, consectetur adipiscing elit. Praesent ullamcorper volutpat mauris. Suspendisse ornare odio pharetra",
            "D",
            60,
            null,
            listOf("A", "B", "C", "D"),
        ),
    )
}