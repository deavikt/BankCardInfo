package ru.salfa.data.repositories

import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import ru.salfa.data.local.BankCardDao
import ru.salfa.data.mappers.FromBankCardDtoToBankCardMapper
import ru.salfa.data.mappers.FromBankCardEntityToBankCardMapper
import ru.salfa.data.mappers.FromBankCardToBankCardEntityMapper
import ru.salfa.domain.models.BankCard
import ru.salfa.domain.models.ResponseError
import ru.salfa.domain.models.ResponseResult
import ru.salfa.data.remote.BankCardApi
import ru.salfa.domain.repositories.BankCardRepository

internal class BankCardRepositoryImpl(
    private val bankCardApi: BankCardApi,
    private val bankCardDao: BankCardDao,
    private val fromBankCardDtoToBankCardMapper: FromBankCardDtoToBankCardMapper,
    private val fromBankCardEntityToBankCardMapper: FromBankCardEntityToBankCardMapper,
    private val fromBankCardToBankCardEntityMapper: FromBankCardToBankCardEntityMapper
) : BankCardRepository {
    override fun getBankCardFlow(bin: String): Flow<ResponseResult<BankCard>> = flow {
        try {
            val response = bankCardApi.getBankCard(bin)
            val responseBody = response.body()

            if (response.isSuccessful && responseBody != null && responseBody.number != null) {
                emit(
                    ResponseResult.Success(
                        fromBankCardDtoToBankCardMapper.map(responseBody)
                    )
                )
            } else {
                emit(ResponseResult.Error(ResponseError.NotFound))
            }
        } catch (exception: Throwable) {
            emit(ResponseResult.Error(ResponseError.FailedInternetConnection))
        }
    }

    override fun getBankCardsFlow(): Flow<List<BankCard>> = flow {
        bankCardDao.getBankCards()
            .collect { bankCards ->
                emit(
                    bankCards.map { bankCard ->
                        fromBankCardEntityToBankCardMapper.map(bankCard)
                    }
                )
            }
    }

    override suspend fun insertBankCardIntoDB(bankCard: BankCard) {
        bankCardDao.insertBankCard(
            fromBankCardToBankCardEntityMapper.map(bankCard)
        )
    }
}