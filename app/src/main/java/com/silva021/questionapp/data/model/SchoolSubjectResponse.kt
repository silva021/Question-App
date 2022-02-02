package com.silva021.questionapp.data.model

import com.silva021.questionapp.domain.model.SchoolSubject

data class SchoolSubjectResponse(
    val codigo: Int = 0,
    val nome: String
)

fun SchoolSubjectResponse.toModel() = SchoolSubject(
    this.codigo,
    this.nome
)