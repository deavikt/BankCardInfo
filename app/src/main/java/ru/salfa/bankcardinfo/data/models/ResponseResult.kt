package ru.salfa.bankcardinfo.data.models

sealed class ResponseResult<T : Any> {
    class Success<T: Any>(val data: T): ResponseResult<T>()
    class Error<T: Any>(val error: ResponseError): ResponseResult<T>()
}