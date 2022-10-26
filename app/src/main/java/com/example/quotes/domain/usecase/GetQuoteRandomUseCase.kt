package com.example.quotes.domain.usecase

import com.example.quotes.domain.QuoteRepository
import com.example.quotes.domain.model.QuoteModel
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

class GetQuoteRandomUseCase @Inject constructor(
    private val quoteRepository: QuoteRepository
){
    suspend fun getQuoteRandom(): Flow<QuoteModel> = quoteRepository.getQuoteRandom()
}