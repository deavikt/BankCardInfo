package ru.salfa.domain.usecases.interfaces

import ru.salfa.domain.models.BankCard

interface InsertBankCardUseCase {
    suspend operator fun invoke(bankCard: BankCard)
}