package com.translator.translatorkmmapp.translate.presentation

import com.translator.translatorkmmapp.core.presentation.UiLanguage

data class UiHistoryItem(
    val id: Long?,
    val fromLanguage: UiLanguage,
    val fromText: String,
    val toLanguage: UiLanguage,
    val toText: String
)
