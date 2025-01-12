package ru.salfa.domain.usecases.interfaces

import kotlinx.coroutines.flow.Flow
import ru.salfa.domain.models.BankCardRemote
import ru.salfa.domain.models.ResponseResult

interface GetBankCardUseCase {
    operator fun invoke(bin: String): Flow<ResponseResult<BankCardRemote>>
}