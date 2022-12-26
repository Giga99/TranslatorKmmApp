package com.translator.translatorkmmapp.translate.domain.history

import com.translator.translatorkmmapp.core.domain.util.CommonFlow

interface HistoryDataSource {

    fun getHistory(): CommonFlow<List<HistoryItem>>

    suspend fun insertHistoryItem(item: HistoryItem)
}
