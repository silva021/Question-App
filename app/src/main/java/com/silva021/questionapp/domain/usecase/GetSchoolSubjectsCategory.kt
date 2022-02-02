package com.silva021.questionapp.domain.usecase

import com.silva021.questionapp.data.model.toModel
import com.silva021.questionapp.data.repository.QuestionRepository
import com.silva021.questionapp.domain.model.SchoolSubject
import com.silva021.questionapp.domain.model.SchoolSubjectCategory

class GetSchoolSubjectsCategory(
    private val questionRepository: QuestionRepository,
) : GetSchoolSubjectsCategoryUseCase {

    override suspend fun invoke(subjectId: Int): List<SchoolSubjectCategory> {
        return questionRepository.getSchoolSubjectsCategory(subjectId).map { it.toModel() }
    }
}

interface GetSchoolSubjectsCategoryUseCase {
    suspend operator fun invoke(subjectId: Int): List<SchoolSubjectCategory>
}