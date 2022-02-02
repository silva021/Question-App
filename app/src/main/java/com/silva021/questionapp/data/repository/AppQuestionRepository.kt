package com.silva021.questionapp.data.repository

import com.silva021.questionapp.data.api.QuestionApi
import com.silva021.questionapp.data.model.AlternativeResponse
import com.silva021.questionapp.data.model.QuestionResponse
import com.silva021.questionapp.data.model.SchoolSubjectCategoryResponse
import com.silva021.questionapp.data.model.SchoolSubjectResponse

class AppQuestionRepository(private val questionApi: QuestionApi) : QuestionRepository {
    override suspend fun getSchoolSubjects(): List<SchoolSubjectResponse> {
        return questionApi.getSubjects()
    }

    override suspend fun getSchoolSubjectsCategory(subjectId: Int): List<SchoolSubjectCategoryResponse> {
        return questionApi.getSubjectsCategory(subjectId)
    }

    override suspend fun getQuestions(categoryId: Int): List<QuestionResponse> {
        return questionApi.getQuestions(categoryId)
    }

    override suspend fun getAlternative(questionId: Int): List<AlternativeResponse> {
        return questionApi.getQuestionsAlternative(questionId)
    }
}

interface QuestionRepository {
    suspend fun getSchoolSubjects(): List<SchoolSubjectResponse>
    suspend fun getSchoolSubjectsCategory(subjectId: Int): List<SchoolSubjectCategoryResponse>
    suspend fun getQuestions(categoryId: Int): List<QuestionResponse>
    suspend fun getAlternative(questionId: Int): List<AlternativeResponse>
}