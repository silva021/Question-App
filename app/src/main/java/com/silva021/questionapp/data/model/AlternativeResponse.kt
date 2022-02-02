package com.silva021.questionapp.data.model

import com.silva021.questionapp.domain.model.Alternative

data class AlternativeResponse(
    val codigo: Int,
    val descricao: String,
    val certo: Boolean,
    val codigoQuestao: Int,
)

fun AlternativeResponse.toModel() = Alternative(
    id = codigo,
    description = descricao,
    isCorrect = certo
)