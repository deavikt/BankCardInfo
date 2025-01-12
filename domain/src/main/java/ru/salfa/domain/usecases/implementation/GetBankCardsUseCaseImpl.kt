package ru.salfa.domain.usecases.implementation

import kotlinx.coroutines.flow.Flow
import ru.salfa.domain.models.BankCardLocal
import ru.salfa.domain.repositories.BankCardRepository
import ru.salfa.domain.usecases.interfaces.GetBankCardsUseCase

internal class GetBankCardsUseCaseImpl(
    private val bankCardRepository: BankCardRepository
) : GetBankCardsUseCase {
    override fun invoke(): Flow<List<BankCardLocal>> = bankCardRepository.getBankCardsFlow()
}