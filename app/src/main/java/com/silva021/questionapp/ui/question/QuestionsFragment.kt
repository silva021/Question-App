package com.silva021.questionapp.ui.question

import android.os.Bundle
import android.view.View
import com.silva021.questionapp.databinding.FragmentQuestionBinding
import com.silva021.questionapp.domain.model.Alternative
import com.silva021.questionapp.domain.model.Question
import com.silva021.questionapp.domain.model.SchoolSubjectCategory
import com.silva021.questionapp.ui.fixquestiondialog.FixQuestionDialogFragment
import com.silva021.questionapp.ui.question.adapter.QuestionAdapter
import com.silva021.toolkit.base.BaseFragment
import com.silva021.toolkit.extension.gone
import com.silva021.toolkit.extension.visible
import org.koin.androidx.viewmodel.ext.android.sharedViewModel

class QuestionsFragment : BaseFragment<FragmentQuestionBinding>() {
    private val viewModel: QuestionsViewModel by sharedViewModel()
    private var questionAdapter: QuestionAdapter? = null

    private val fixQuestionListener: (Alternative) -> Unit = {
        FixQuestionDialogFragment(
            it
        ).show(
            parentFragmentManager,
            FixQuestionDialogFragment::class.qualifiedName
        )
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        recoverArguments<SchoolSubjectCategory> {
            binding.setupToolbar(it.name)
            viewModel.getQuestionWithAlternative(it.id)
        }

        setupListener()
        setupObserver()
    }

    private fun setupListener() {
        with(binding) {
            button.setOnClickListener {
                questionAdapter?.fixQuestion()
                it.gone()
            }
        }
    }

    private fun setupObserver() {
        viewModel.questions.observe(viewLifecycleOwner) { questions ->
            binding.initAdapter(questions)
        }
    }

    private fun FragmentQuestionBinding.setupToolbar(name: String) {
        toolbar.apply {
            title = name

            setOnClickListener {
                requireActivity().onBackPressed()
            }
        }
    }

    private fun FragmentQuestionBinding.initAdapter(listQuestion: List<Question>) {
        questionAdapter = QuestionAdapter(
            listOf(
                listQuestion[1]
            ),
            {
                checkVisibilityButton(it)
            },
            fixQuestionListener
        )


        questionList.apply {
            this.adapter = questionAdapter
        }
    }

    private fun checkVisibilityButton(alternative: Alternative?) {
        with(binding) {
            alternative?.let {
                button.visible()
            } ?: run {
                button.gone()
            }
        }
    }

    override fun getViewBinding() = FragmentQuestionBinding.inflate(layoutInflater)
}