package com.translator.translatorkmmapp.di

import com.translator.translatorkmmapp.database.TranslateDatabase
import com.translator.translatorkmmapp.translate.data.history.SqlDelightHistoryDataSource
import com.translator.translatorkmmapp.translate.data.local.DatabaseDriverFactory
import com.translator.translatorkmmapp.translate.data.remote.HttpClientFactory
import com.translator.translatorkmmapp.translate.data.translate.KtorTranslateClient
import com.translator.translatorkmmapp.translate.domain.history.HistoryDataSource
import com.translator.translatorkmmapp.translate.domain.translate.Translate
import com.translator.translatorkmmapp.translate.domain.translate.TranslateClient

class AppModule {

    val historyDataSource: HistoryDataSource by lazy {
        SqlDelightHistoryDataSource(TranslateDatabase(DatabaseDriverFactory().create()))
    }

    private val translateClient: TranslateClient by lazy {
        KtorTranslateClient(HttpClientFactory().create())
    }

    val translateUseCase: Translate by lazy {
        Translate(client = translateClient, historyDataSource = historyDataSource)
    }
}
