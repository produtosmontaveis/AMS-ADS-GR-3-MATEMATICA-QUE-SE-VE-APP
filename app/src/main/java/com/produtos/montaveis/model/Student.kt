package com.produtos.montaveis.model

data class Student(
    val id: Long,
    val name: String,
    var level: Int,
    var score: Int,
    val challenges: List<Challenge>?
)
