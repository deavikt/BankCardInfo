package ru.salfa.domain.repositories

import kotlinx.coroutines.flow.Flow
import ru.salfa.domain.models.BankCardLocal
import ru.salfa.domain.models.BankCardRemote
import ru.salfa.domain.models.ResponseResult

interface BankCardRepository {
    fun getBankCardFlow(bin: String): Flow<ResponseResult<BankCardRemote>>
    fun getBankCardsFlow(): Flow<List<BankCardLocal>>
    suspend fun insertBankCard(bankCard: BankCardLocal)
}