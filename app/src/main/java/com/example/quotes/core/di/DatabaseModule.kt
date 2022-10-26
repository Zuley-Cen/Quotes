package com.example.quotes.core.di

import android.content.Context
import com.example.quotes.data.local.QuoteDB
import com.example.quotes.data.local.daos.QuoteDao
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.SupervisorJob
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
class DatabaseModule {

    @Provides
    @Singleton
    fun provideQuoteDao(quoteDB: QuoteDB): QuoteDao {
        return quoteDB.quoteDao()
    }

    @Provides
    @Singleton
    fun provideGetDatabase(@ApplicationContext appContext: Context,
                           scope: CoroutineScope
    ): QuoteDB {
        return QuoteDB.getDatabase(appContext, scope)
    }

    @Singleton // Provide always the same instance
    @Provides
    fun provideCoroutineScope(): CoroutineScope {
        return CoroutineScope(SupervisorJob() + Dispatchers.IO)
    }

}
