package com.translator.translatorkmmapp.translate.domain.translate

import com.translator.translatorkmmapp.core.domain.language.Language

interface TranslateClient {

    suspend fun translate( fromLanguage: Language, fromText: String, toLanguage: Language): String
}
