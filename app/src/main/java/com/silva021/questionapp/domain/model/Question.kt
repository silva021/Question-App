package com.silva021.questionapp.domain.model

data class Question(
    val codigo: Int,
    val descricao: String,
    val listAlternative: List<Alternative>
)
