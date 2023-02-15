package com.aldikitta.serverdrivenuisimplified.core.commons

import kotlinx.coroutines.flow.*

sealed interface NetworkResponse<out T> {
    data class Success<T>(val data: T) : NetworkResponse<T>
    data class Error(val exception: Throwable? = null) : NetworkResponse<Nothing>
    data class Loading(val status: Boolean) : NetworkResponse<Nothing>
}

fun <T> Flow<T>.asResponse(): Flow<NetworkResponse<T>> {
    return this
        .map<T, NetworkResponse<T>> {
            NetworkResponse.Success(it)
        }
        .onStart { emit(NetworkResponse.Loading(true)) }
        .onCompletion { emit(NetworkResponse.Loading(false)) }
        .catch { error ->
            emit(NetworkResponse.Error(Throwable(message = error.message)))
            emit(NetworkResponse.Error(error))
            emit(NetworkResponse.Loading(false))
        }
}