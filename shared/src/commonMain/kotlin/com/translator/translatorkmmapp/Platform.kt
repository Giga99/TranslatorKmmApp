package com.translator.translatorkmmapp

interface Platform {
    val name: String
}

expect fun getPlatform(): Platform