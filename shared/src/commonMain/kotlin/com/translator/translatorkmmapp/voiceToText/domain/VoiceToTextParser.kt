package com.translator.translatorkmmapp.voiceToText.domain

import com.translator.translatorkmmapp.core.domain.util.CommonStateFlow

interface VoiceToTextParser {

    val state: CommonStateFlow<VoiceToTextParserState>

    fun startListening(languageCode: String)

    fun stopListening()

    fun cancel()

    fun reset()
}
