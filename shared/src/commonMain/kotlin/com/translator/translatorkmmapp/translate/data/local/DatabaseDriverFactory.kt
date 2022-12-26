package com.translator.translatorkmmapp.translate.data.local

import com.squareup.sqldelight.db.SqlDriver

expect class DatabaseDriverFactory {

    fun create(): SqlDriver
}
