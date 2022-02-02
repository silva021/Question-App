package com.silva021.questionapp.domain.usecase

import com.silva021.questionapp.data.model.toModel
import com.silva021.questionapp.data.repository.QuestionRepository
import com.silva021.questionapp.domain.model.Question

class GetQuestions(
    private val questionRepository: QuestionRepository,
) : GetQuestionsUseCase {
    override suspend fun invoke(categoryId: Int): List<Question> {
        return questionRepository.getQuestions(categoryId).map { questionResponse ->
            val alternatives = questionRepository.getAlternative(questionResponse.codigo)

            questionResponse.toModel(
                alternatives = alternatives.map { it.toModel() }
            )
        }
    }
}

interface GetQuestionsUseCase {
    suspend operator fun invoke(categoryId: Int): List<Question>
}