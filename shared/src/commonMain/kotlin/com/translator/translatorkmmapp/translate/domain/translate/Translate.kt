package com.translator.translatorkmmapp.translate.domain.translate

import com.translator.translatorkmmapp.core.domain.language.Language
import com.translator.translatorkmmapp.core.domain.util.Resource
import com.translator.translatorkmmapp.translate.domain.history.HistoryDataSource
import com.translator.translatorkmmapp.translate.domain.history.HistoryItem

class Translate(
    private val client: TranslateClient,
    private val historyDataSource: HistoryDataSource
) {

    suspend fun execute(
        fromLanguage: Language,
        fromText: String,
        toLanguage: Language
    ): Resource<String> =
        try {
            val translatedText = client.translate(fromLanguage, fromText, toLanguage)
            historyDataSource.insertHistoryItem(
                HistoryItem(
                    id = null,
                    fromLanguageCode = fromLanguage.langCode,
                    fromText = fromText,
                    toLanguageCode = toLanguage.langCode,
                    toText = translatedText
                )
            )
            Resource.Success(translatedText)
        } catch (e: TranslateException) {
            e.printStackTrace()
            Resource.Error(e)
        }
}
