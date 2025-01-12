package ru.salfa.domain.usecases.interfaces

import ru.salfa.domain.models.BankCardLocal

interface InsertBankCardUseCase {
    suspend operator fun invoke(bankCard: BankCardLocal)
}