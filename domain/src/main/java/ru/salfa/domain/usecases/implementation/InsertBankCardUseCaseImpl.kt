package ru.salfa.domain.usecases.implementation

import ru.salfa.domain.models.BankCard
import ru.salfa.domain.repositories.BankCardRepository
import ru.salfa.domain.usecases.interfaces.InsertBankCardUseCase

class InsertBankCardUseCaseImpl(
    private val bankCardRepository: BankCardRepository
) : InsertBankCardUseCase {
    override suspend fun invoke(bankCard: BankCard) = bankCardRepository.insertBankCard(bankCard)
}