package com.silva021.questionapp.data.model

import com.silva021.questionapp.domain.model.SchoolSubjectCategory

data class SchoolSubjectCategoryResponse(
    val codigo: Int = 0,
    val nome: String,
    val codigoMateria: Int = 0,
)

fun SchoolSubjectCategoryResponse.toModel() = SchoolSubjectCategory(
    this.codigo,
    this.nome,
)