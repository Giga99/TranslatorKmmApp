package com.translator.translatorkmmapp.core.presentation

import com.translator.translatorkmmapp.core.domain.language.Language

expect class UiLanguage {

    val language: Language

    companion object {
        fun byCode(langCode: String): UiLanguage
        val allLanguages: List<UiLanguage>
    }
}
