package ru.salfa.domain.repositories

import kotlinx.coroutines.flow.Flow
import ru.salfa.domain.models.BankCard
import ru.salfa.domain.models.ResponseResult

interface BankCardRepository {
    fun getBankCardFlow(bin: String): Flow<ResponseResult<BankCard>>
    fun getBankCardsFlow(): Flow<List<BankCard>>
    suspend fun insertBankCardIntoDB(bankCard: BankCard)
}