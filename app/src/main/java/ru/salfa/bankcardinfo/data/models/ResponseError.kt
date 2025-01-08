package ru.salfa.bankcardinfo.data.models

sealed class ResponseError {
    data class NotFound(val code: Int = 404) : ResponseError()
    data object FailedInternetConnection : ResponseError()
}