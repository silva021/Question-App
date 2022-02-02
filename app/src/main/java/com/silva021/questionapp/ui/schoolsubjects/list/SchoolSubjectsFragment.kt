package com.silva021.questionapp.ui.schoolsubjects.list

import android.os.Bundle
import android.view.View
import com.silva021.questionapp.databinding.FragmentSchoolSubjectBinding
import com.silva021.questionapp.domain.model.SchoolSubject
import com.silva021.questionapp.ui.schoolsubjects.list.adapter.SchoolSubjectsAdapter
import com.silva021.toolkit.base.BaseFragment
import com.silva021.toolkit.extension.gone
import com.silva021.toolkit.extension.toBundle
import com.silva021.toolkit.extension.toJson
import com.silva021.toolkit.extension.visible
import com.silva021.toolkit.navigation.QuestionNavigation
import org.koin.androidx.viewmodel.ext.android.sharedViewModel

class SchoolSubjectsFragment : BaseFragment<FragmentSchoolSubjectBinding>() {
    private val viewModel: SchoolSubjectsListViewModel by sharedViewModel()

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        viewModel.categories.observe(viewLifecycleOwner) { listCategoryUiModel ->
            initAdapter(listCategoryUiModel)
        }

        viewModel.getCategories()
    }

    private fun initAdapter(list: List<SchoolSubject>) {
        with(binding) {
            loading.gone()
            schoolSubjectsList.apply {
                visible()
                adapter = SchoolSubjectsAdapter(list) { schoolSubject ->
                    navigate(
                        QuestionNavigation.SCHOOL_SUBJECT_CATEGORY_SCREEN,
                        schoolSubject.toJson().toBundle()
                    )
                }
            }
        }
    }

    override fun getViewBinding() = FragmentSchoolSubjectBinding.inflate(layoutInflater)
}