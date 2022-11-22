package com.example.quotes.domain.usecase

import com.example.quotes.domain.QuoteRepository
import com.example.quotes.domain.model.QuoteModel
import javax.inject.Inject

class GetQuoteAddUseCase @Inject constructor(
    private val quoteRepository: QuoteRepository
){
    //  suspend fun getQuoteRandom(): Flow<QuoteModel> = quoteRepository.getQuoteRandom()
    suspend fun addQuote(quoteModel: QuoteModel)=quoteRepository.addQuote(quoteModel)

}