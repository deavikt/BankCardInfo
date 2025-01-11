package ru.salfa.data.repositories

import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import ru.salfa.data.local.BankCardDao
import ru.salfa.data.local.BankCardEntity
import ru.salfa.data.mappers.FromBankCardToBankCardEntityMapper
import ru.salfa.data.models.BankCard
import ru.salfa.data.models.ResponseError
import ru.salfa.data.models.ResponseResult
import ru.salfa.data.remote.BankCardApi

internal class BankCardRepository(
    private val bankCardApi: BankCardApi,
    private val bankCardDao: BankCardDao,
    private val fromBankCardToBankCardEntityMapper: FromBankCardToBankCardEntityMapper
) {
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

    fun getBankCardsFlow(): Flow<List<BankCardEntity>> = bankCardDao.getBankCards()

    suspend fun insertBankCardIntoDB(bankCard: BankCard, bin: String) {
        bankCardDao.insertBankCard(
            fromBankCardToBankCardEntityMapper.map(bankCard, bin)
        )
    }
}