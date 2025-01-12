package ru.salfa.domain.usecases.implementation

import ru.salfa.domain.models.BankCardLocal
import ru.salfa.domain.repositories.BankCardRepository
import ru.salfa.domain.usecases.interfaces.InsertBankCardUseCase

class InsertBankCardUseCaseImpl(
    private val bankCardRepository: BankCardRepository
) : InsertBankCardUseCase {
    override suspend fun invoke(bankCard: BankCardLocal) = bankCardRepository.insertBankCard(bankCard)
}