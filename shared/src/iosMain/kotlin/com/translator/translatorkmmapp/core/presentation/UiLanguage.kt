package com.translator.translatorkmmapp.core.presentation

import com.translator.translatorkmmapp.core.domain.language.Language

actual class UiLanguage(
    val imageName: String,
    actual val language: Language
) {

    actual companion object {
        actual fun byCode(langCode: String): UiLanguage {
            return allLanguages.find { it.language.langCode == langCode }
                ?: throw IllegalArgumentException("Invalid or unsupported language code")
        }

        actual val allLanguages: List<UiLanguage>
            get() = Language.values().map { language ->
                UiLanguage(
                    language = language,
                    imageName = language.langName.lowercase()
                )
            }.sortedBy { it.language.langName }
    }
}
