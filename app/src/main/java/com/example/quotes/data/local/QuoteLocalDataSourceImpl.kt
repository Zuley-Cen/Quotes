package com.example.quotes.data.local

import com.example.quotes.core.utils.toEntity
import com.example.quotes.core.utils.toListQuoteModel
import com.example.quotes.core.utils.toQuoteModel
import com.example.quotes.data.local.daos.QuoteDao
import com.example.quotes.domain.model.QuoteModel
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map
import javax.inject.Inject

class QuoteLocalDataSourceImpl  @Inject constructor(private val quoteDao: QuoteDao): QuoteLocalDataSource {
    override fun getQuotes(): Flow<List<QuoteModel>> {
        val quotes = quoteDao.getQuotes()
        return quotes.map { it.toListQuoteModel() }
    }

    override   fun getQuote(quoteId: Int): Flow<QuoteModel> {
        return  quoteDao.getQuote(quoteId).map { it.toQuoteModel()}
    }

    override fun getQuoteRandom(): Flow<QuoteModel> {
        return  quoteDao.getQuoteRandom().map { it.toQuoteModel() }
    }

    override suspend fun insertAll(quotes: List<QuoteModel>) {
        quoteDao.insertAll(quotes!!.map { it.toEntity()})
    }

    override suspend fun insert(quoteModel: QuoteModel) {
        quoteDao.insert(quoteModel.toEntity())
    }

}