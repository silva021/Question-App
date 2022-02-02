package com.silva021.questionapp.ui.schoolsubjects.category

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.silva021.questionapp.domain.model.SchoolSubjectCategory
import com.silva021.questionapp.domain.usecase.GetSchoolSubjectsCategoryUseCase
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch

class SchoolSubjectsCategoryViewModel(
    private val getSchoolSubjectsCategory: GetSchoolSubjectsCategoryUseCase,
) : ViewModel() {

    private val _categories = MutableLiveData<List<SchoolSubjectCategory>>()
    val categories = _categories as LiveData<List<SchoolSubjectCategory>>

    fun getSubjectCategories(subjectId: Int) {
        viewModelScope.launch {
            val categoryList = getSchoolSubjectsCategory(subjectId)

            _categories.value = categoryList
        }
    }

}