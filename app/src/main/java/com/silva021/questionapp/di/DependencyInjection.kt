package com.silva021.questionapp.di

import com.silva021.questionapp.data.api.QuestionApi
import com.silva021.questionapp.data.repository.AppQuestionRepository
import com.silva021.questionapp.data.repository.QuestionRepository
import com.silva021.questionapp.domain.usecase.GetQuestions
import com.silva021.questionapp.domain.usecase.GetQuestionsUseCase
import com.silva021.questionapp.domain.usecase.GetSchoolSubjects
import com.silva021.questionapp.domain.usecase.GetSchoolSubjectsCategory
import com.silva021.questionapp.domain.usecase.GetSchoolSubjectsCategoryUseCase
import com.silva021.questionapp.domain.usecase.GetSchoolSubjectsUseCase
import com.silva021.questionapp.ui.question.QuestionsViewModel
import com.silva021.questionapp.ui.schoolsubjects.category.SchoolSubjectsCategoryViewModel
import com.silva021.questionapp.ui.schoolsubjects.list.SchoolSubjectsListViewModel
import com.silva021.toolkit.network.Service
import org.koin.dsl.module

val questionModule = module {
    single { Service().createService(QuestionApi::class.java) }
    single<QuestionRepository> { AppQuestionRepository(get()) }

    single<GetSchoolSubjectsUseCase> { GetSchoolSubjects(get()) }
    single { SchoolSubjectsListViewModel(get()) }

    single<GetSchoolSubjectsCategoryUseCase> { GetSchoolSubjectsCategory(get()) }
    single { SchoolSubjectsCategoryViewModel(get()) }

    single<GetQuestionsUseCase> { GetQuestions(get()) }
    single { QuestionsViewModel(get()) }
}