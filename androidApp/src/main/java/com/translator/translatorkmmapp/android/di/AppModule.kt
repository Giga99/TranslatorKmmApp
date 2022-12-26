package com.translator.translatorkmmapp.android.di

import android.app.Application
import com.squareup.sqldelight.db.SqlDriver
import com.translator.translatorkmmapp.database.TranslateDatabase
import com.translator.translatorkmmapp.translate.data.history.SqlDelightHistoryDataSource
import com.translator.translatorkmmapp.translate.data.local.DatabaseDriverFactory
import com.translator.translatorkmmapp.translate.data.remote.HttpClientFactory
import com.translator.translatorkmmapp.translate.data.translate.KtorTranslateClient
import com.translator.translatorkmmapp.translate.domain.history.HistoryDataSource
import com.translator.translatorkmmapp.translate.domain.translate.Translate
import com.translator.translatorkmmapp.translate.domain.translate.TranslateClient
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import io.ktor.client.*
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object AppModule {

    @Provides
    @Singleton
    fun provideHttpClient(): HttpClient {
        return HttpClientFactory().create()
    }

    @Provides
    @Singleton
    fun provideTranslateClient(httpClient: HttpClient): TranslateClient {
        return KtorTranslateClient(httpClient)
    }

    @Provides
    @Singleton
    fun provideDatabaseDriver(app: Application): SqlDriver {
        return DatabaseDriverFactory(app).create()
    }

    @Provides
    @Singleton
    fun provideHistoryDataSource(driver: SqlDriver): HistoryDataSource {
        return SqlDelightHistoryDataSource(TranslateDatabase(driver))
    }

    @Provides
    @Singleton
    fun provideTranslateUseCase(
        client: TranslateClient,
        dataSource: HistoryDataSource
    ): Translate {
        return Translate(client, dataSource)
    }
}
