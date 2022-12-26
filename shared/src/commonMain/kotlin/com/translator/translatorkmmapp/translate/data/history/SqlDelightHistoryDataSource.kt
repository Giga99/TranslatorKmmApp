package com.translator.translatorkmmapp.translate.data.history

import com.squareup.sqldelight.runtime.coroutines.asFlow
import com.squareup.sqldelight.runtime.coroutines.mapToList
import com.translator.translatorkmmapp.core.domain.util.CommonFlow
import com.translator.translatorkmmapp.core.domain.util.toCommonFlow
import com.translator.translatorkmmapp.database.TranslateDatabase
import com.translator.translatorkmmapp.translate.domain.history.HistoryDataSource
import com.translator.translatorkmmapp.translate.domain.history.HistoryItem
import kotlinx.coroutines.flow.map
import kotlinx.datetime.Clock

class SqlDelightHistoryDataSource(
    db: TranslateDatabase
) : HistoryDataSource {

    private val queries = db.translateQueries

    override fun getHistory(): CommonFlow<List<HistoryItem>> {
        return queries
            .getHistory()
            .asFlow()
            .mapToList()
            .map { history ->
                history.map { it.toHistoryItem() }
            }
            .toCommonFlow()
    }

    override suspend fun insertHistoryItem(item: HistoryItem) {
        queries.insertHistoryEntity(
            id = item.id,
            fromLanguageCode = item.fromLanguageCode,
            fromText = item.fromText,
            toLanguageCode = item.toLanguageCode,
            toText = item.toText,
            timestamp = Clock.System.now().toEpochMilliseconds()
        )
    }
}
