package ru.salfa.presentation.models

import ru.salfa.domain.models.BankCardRemote
import ru.salfa.domain.models.ResponseError

internal sealed class BankCardLoadingState {
    data object Empty : BankCardLoadingState()
    data object Loading : BankCardLoadingState()
    data class Success(val bankCard: BankCardRemote): BankCardLoadingState()
    data class Error(val error: ResponseError) : BankCardLoadingState()
}