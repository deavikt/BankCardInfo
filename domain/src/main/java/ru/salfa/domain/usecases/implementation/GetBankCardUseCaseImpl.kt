package ru.salfa.domain.usecases.implementation

import kotlinx.coroutines.flow.Flow
import ru.salfa.domain.models.BankCardRemote
import ru.salfa.domain.models.ResponseResult
import ru.salfa.domain.repositories.BankCardRepository
import ru.salfa.domain.usecases.interfaces.GetBankCardUseCase

internal class GetBankCardUseCaseImpl(
    private val bankCardRepository: BankCardRepository
) : GetBankCardUseCase {
    override fun invoke(bin: String): Flow<ResponseResult<BankCardRemote>> = bankCardRepository.getBankCardFlow(bin)
}