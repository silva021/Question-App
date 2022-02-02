package com.silva021.questionapp.ui.question.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.silva021.questionapp.databinding.QuestionItemBinding
import com.silva021.questionapp.domain.model.Alternative
import com.silva021.questionapp.domain.model.Question

class QuestionAdapter(
    private val listQuestion: List<Question>,
    private val alternativeSelectedListener: (Alternative?) -> Unit,
    private val fixQuestionListener: (Alternative) -> Unit,
) : RecyclerView.Adapter<QuestionAdapter.QuestionAdapterViewHolder>() {
    var holder: QuestionAdapterViewHolder? = null

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): QuestionAdapterViewHolder {
        holder =
            QuestionAdapterViewHolder(
                QuestionItemBinding.inflate(LayoutInflater.from(parent.context),
                    parent,
                    false
                )
            )
        return holder!!
    }

    override fun onBindViewHolder(holder: QuestionAdapterViewHolder, position: Int) {
        holder.bind(listQuestion[position], position)
    }

    override fun getItemCount() = listQuestion.size

    fun fixQuestion() {
        holder?.fixQuestion()
    }

    inner class QuestionAdapterViewHolder(
        private val binding: QuestionItemBinding,
    ) : RecyclerView.ViewHolder(binding.root) {
        private var questionAdapter: AlternativeAdapter? = null

        fun bind(question: Question, position: Int) {
            with(binding) {
                txtTitle.text = "Questão " + (position + 1)
                txtDescription.text = question.descricao.replace("/n", "\n\n")

                questionAdapter = AlternativeAdapter(
                    question.listAlternative,
                    alternativeSelectedListener,
                    fixQuestionListener
                )

                questionAlternativeList.apply {
                    adapter = questionAdapter
                }
            }
        }

        fun fixQuestion() {
            questionAdapter?.fixQuestion()
        }
    }
}
