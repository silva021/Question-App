package com.silva021.questionapp.ui.fixquestiondialog

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.DialogFragment
import com.silva021.questionapp.R
import com.silva021.questionapp.databinding.FixQuestionDialogFragmentBinding
import com.silva021.questionapp.domain.model.Alternative

class FixQuestionDialogFragment(
    private val alternative: Alternative,
) : DialogFragment() {
    private lateinit var binding: FixQuestionDialogFragmentBinding

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?,
    ): View {
        binding =
            FixQuestionDialogFragmentBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding.setupText()
    }

    private fun FixQuestionDialogFragmentBinding.setupText() {
        message.text = if (alternative.isCorrect)
            getString(R.string.correct_alternative)
        else
            getString(R.string.wrong_alternative)
    }
}