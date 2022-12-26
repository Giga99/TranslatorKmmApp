package com.translator.translatorkmmapp.translate.data.local

import android.content.Context
import com.squareup.sqldelight.android.AndroidSqliteDriver
import com.squareup.sqldelight.db.SqlDriver
import com.translator.translatorkmmapp.database.TranslateDatabase

actual class DatabaseDriverFactory(
    private val context: Context
) {

    actual fun create(): SqlDriver {
        return AndroidSqliteDriver(TranslateDatabase.Schema, context, "translate.db")
    }
}
