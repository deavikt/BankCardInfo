package ru.salfa.bankcardinfo.data.repositories

import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import ru.salfa.bankcardinfo.data.models.BankCard
import ru.salfa.bankcardinfo.data.models.ResponseError
import ru.salfa.bankcardinfo.data.models.ResponseResult
import ru.salfa.bankcardinfo.data.network.BankCardApi

class BankCardRepository(private val bankCardApi: BankCardApi) {

    fun getBankCardFlow(bin: String): Flow<ResponseResult<BankCard>> = flow {
        try {
            val response = bankCardApi.getBankCard(bin)
            val responseBody = response.body()

            if (response.isSuccessful && responseBody != null && responseBody.number != null) {
                emit(ResponseResult.Success(responseBody))
            } else {
                emit(ResponseResult.Error(ResponseError.NotFound))
            }
        } catch (exception: Throwable) {
            emit(ResponseResult.Error(ResponseError.FailedInternetConnection))
        }
    }
}