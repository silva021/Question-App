package com.silva021.questionapp.ui.schoolsubjects.category

import android.os.Bundle
import android.view.View
import com.silva021.questionapp.databinding.FragmentSchoolSubjectCategoryBinding
import com.silva021.questionapp.domain.model.SchoolSubject
import com.silva021.questionapp.domain.model.SchoolSubjectCategory
import com.silva021.questionapp.ui.schoolsubjects.category.adapter.SchoolSubjectsCategoryAdapter
import com.silva021.toolkit.base.BaseFragment
import com.silva021.toolkit.extension.gone
import com.silva021.toolkit.extension.toBundle
import com.silva021.toolkit.extension.toJson
import com.silva021.toolkit.extension.visible
import com.silva021.toolkit.navigation.QuestionNavigation
import org.koin.androidx.viewmodel.ext.android.sharedViewModel

class SchoolSubjectsCategoryFragment : BaseFragment<FragmentSchoolSubjectCategoryBinding>() {
    private val viewModel: SchoolSubjectsCategoryViewModel by sharedViewModel()

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        recoverArguments<SchoolSubject> {
            binding.setupToolbar(it.name)
            viewModel.getSubjectCategories(it.id)
        }

        viewModel.categories.observe(viewLifecycleOwner) { listCategoryUiModel ->
            initAdapter(listCategoryUiModel)
        }
    }

    private fun FragmentSchoolSubjectCategoryBinding.setupToolbar(name: String) {
        toolbar.apply {
            title = name

            setOnClickListener {
                requireActivity().onBackPressed()
            }
        }
    }

    private fun initAdapter(list: List<SchoolSubjectCategory>) {
        with(binding) {
            binding.loading.gone()
            this.list.apply {
                visible()
                adapter = SchoolSubjectsCategoryAdapter(list) { schoolSubjectCategory ->
                    navigate(
                        QuestionNavigation.QUESTION_SCREEN,
                        schoolSubjectCategory.toJson().toBundle()
                    )
                }
            }
        }
    }

    override fun getViewBinding() = FragmentSchoolSubjectCategoryBinding.inflate(layoutInflater)
}