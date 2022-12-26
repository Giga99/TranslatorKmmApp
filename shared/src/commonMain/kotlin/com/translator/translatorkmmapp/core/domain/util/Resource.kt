package com.translator.translatorkmmapp.core.domain.util

sealed class Resource<T>(val data: T? = null, val throwable: Throwable? = null) {
    class Success<T>(data: T) : Resource<T>(data = data)
    class Error<T>(throwable: Throwable) : Resource<T>(throwable = throwable)
}
