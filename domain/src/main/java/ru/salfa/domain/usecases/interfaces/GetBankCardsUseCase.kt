package ru.salfa.domain.usecases.interfaces

import kotlinx.coroutines.flow.Flow
import ru.salfa.domain.models.BankCardLocal

interface GetBankCardsUseCase {
    operator fun invoke(): Flow<List<BankCardLocal>>
}