package com.silva021.questionapp.data.api

import com.silva021.questionapp.data.model.AlternativeResponse
import com.silva021.questionapp.data.model.QuestionResponse
import com.silva021.questionapp.data.model.SchoolSubjectCategoryResponse
import com.silva021.questionapp.data.model.SchoolSubjectResponse
import retrofit2.http.GET
import retrofit2.http.Query

interface QuestionApi {
    @GET("subjects")
    suspend fun getSubjects(): List<SchoolSubjectResponse>

    @GET("category")
    suspend fun getSubjectsCategory(@Query(value = "subjectId") subjectId: Int): List<SchoolSubjectCategoryResponse>

    @GET("questions")
    suspend fun getQuestions(
        @Query(value = "categoryId") categoryId: Int,
    ): List<QuestionResponse>

    @GET("alternative")
    suspend fun getQuestionsAlternative(
        @Query(value = "questionId"
        ) questionId: Int,
    ): List<AlternativeResponse>
}