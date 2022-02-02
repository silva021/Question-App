package com.silva021.questionapp.data.model

import com.silva021.questionapp.domain.model.Alternative
import com.silva021.questionapp.domain.model.Question

data class QuestionResponse(
    val codigo: Int,
    val descricao: String,
    val codigoCategoria: Int,
)

fun QuestionResponse.toModel(alternatives: List<Alternative>) =
    Question(
        this.codigo,
        this.descricao,
        alternatives
    )