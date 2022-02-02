package com.silva021.questionapp.ui.question

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.silva021.questionapp.domain.model.Question
import com.silva021.questionapp.domain.model.SchoolSubjectCategory
import com.silva021.questionapp.domain.usecase.GetQuestions
import com.silva021.questionapp.domain.usecase.GetQuestionsUseCase
import com.silva021.questionapp.domain.usecase.GetSchoolSubjectsCategoryUseCase
import kotlinx.coroutines.launch

class QuestionsViewModel(
    private val getQuestion: GetQuestionsUseCase,
) : ViewModel() {

    private val _question = MutableLiveData<List<Question>>()
    val questions = _question as LiveData<List<Question>>

    fun getQuestionWithAlternative(subjectId: Int) {
        viewModelScope.launch {
            val categoryList = getQuestion(subjectId)

            _question.value = categoryList
        }
    }

}