package com.silva021.questionapp.ui.schoolsubjects.list

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.silva021.questionapp.domain.model.SchoolSubject
import com.silva021.questionapp.domain.usecase.GetSchoolSubjectsUseCase
import kotlinx.coroutines.launch

class SchoolSubjectsListViewModel(
    private val getSchoolSubjectsUseCase: GetSchoolSubjectsUseCase,
) : ViewModel() {

    private val _categories = MutableLiveData<List<SchoolSubject>>()
    val categories = _categories as LiveData<List<SchoolSubject>>

    fun getCategories() {
        viewModelScope.launch {
            val categoryList = getSchoolSubjectsUseCase

            _categories.value = categoryList.getSchoolSubjects()
        }
    }

}