package com.silva021.questionapp.domain.usecase

import com.silva021.questionapp.data.model.toModel
import com.silva021.questionapp.data.repository.QuestionRepository
import com.silva021.questionapp.domain.model.SchoolSubject

class GetSchoolSubjects(private val questionRepository: QuestionRepository) : GetSchoolSubjectsUseCase {
    override suspend fun getSchoolSubjects(): List<SchoolSubject> {
        return questionRepository.getSchoolSubjects().map { it.toModel() }
    }
}

interface GetSchoolSubjectsUseCase {
    suspend fun getSchoolSubjects(): List<SchoolSubject>
}