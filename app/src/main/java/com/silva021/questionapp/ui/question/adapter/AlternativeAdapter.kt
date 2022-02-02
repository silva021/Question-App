package com.silva021.questionapp.ui.question.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.core.content.ContextCompat.getColor
import androidx.recyclerview.widget.RecyclerView
import com.silva021.questionapp.R
import com.silva021.questionapp.databinding.QuestionAlternativeItemBinding
import com.silva021.questionapp.domain.model.Alternative
import com.silva021.toolkit.extension.gone
import com.silva021.toolkit.extension.load
import com.silva021.toolkit.extension.visible

class AlternativeAdapter(
    private val listAlternative: List<Alternative>,
    private val alternativeSelectedListener: (Alternative?) -> Unit,
    private val fixQuestionListener: (Alternative) -> Unit,
) : RecyclerView.Adapter<AlternativeAdapter.AlternativeAdapterViewHolder>() {
    lateinit var context: Context
    var alternativeSelected: Alternative? = null
    var isCorrected = false
    private val selectedListener: (Alternative) -> Unit = {
        alternativeSelected = if (it.toString() == alternativeSelected.toString())
            null
        else
            it

        notifyDataSetChanged()
    }

    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int,
    ): AlternativeAdapterViewHolder {
        context = parent.context
        val itemBinding = QuestionAlternativeItemBinding.inflate(
            LayoutInflater.from(parent.context),
            parent,
            false
        )
        return AlternativeAdapterViewHolder(itemBinding)
    }

    override fun onBindViewHolder(holder: AlternativeAdapterViewHolder, position: Int) {
        holder.bind(listAlternative[position], position)
    }

    override fun getItemCount() = listAlternative.size

    fun fixQuestion() {
        isCorrected = true
        notifyDataSetChanged()
    }

    inner class AlternativeAdapterViewHolder(
        private val binding: QuestionAlternativeItemBinding,
    ) : RecyclerView.ViewHolder(binding.root) {
        fun bind(
            alternative: Alternative,
            position: Int,
        ) {
            with(binding) {
                txtQuestionOption.text = alternative.description
                setImage(position)
                setImageCheck(alternative)
                checkAlternative(alternative)
                cardViewLayout.setOnClickListener {
                    selectedListener(alternative)
                    alternativeSelectedListener(alternativeSelected)
                }
            }
        }

        private fun QuestionAlternativeItemBinding.checkAlternative(alternative: Alternative) {
            alternativeSelected?.let {
                if (isCorrected && it == alternative) {
                    if (it.isCorrect) {
                        cardViewLayout.setCardBackgroundColor(
                            getColor(
                                context,
                                R.color.alternative_true
                            )
                        )
                    } else {
                        cardViewLayout.setCardBackgroundColor(
                            getColor(
                                context,
                                R.color.alternative_false
                            )
                        )
                    }

                    fixQuestionListener(it)
                    isCorrected = false
                }
            }
        }

        private fun QuestionAlternativeItemBinding.setImageCheck(alternative: Alternative) {
            alternativeSelected?.let {
                if (it.id == alternative.id)
                    imgCheck.visible()
                else
                    imgCheck.gone()
            } ?: run {
                imgCheck.gone()
            }
        }

        private fun QuestionAlternativeItemBinding.setImage(position: Int) {
            when (position) {
                0 -> imgQuestion.load(R.drawable.ic_one)
                1 -> imgQuestion.load(R.drawable.ic_two)
                2 -> imgQuestion.load(R.drawable.ic_three)
                3 -> imgQuestion.load(R.drawable.ic_four)
                4 -> imgQuestion.load(R.drawable.ic_five)
                else -> imgQuestion.load(R.drawable.ic_six)
            }
        }
    }
}
