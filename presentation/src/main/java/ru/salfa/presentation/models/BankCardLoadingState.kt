package ru.salfa.presentation.models

import ru.salfa.data.models.BankCard
import ru.salfa.data.models.ResponseError

internal sealed class BankCardLoadingState {
    data object Empty : BankCardLoadingState()
    data object Loading : BankCardLoadingState()
    data class Success(val bankCard: BankCard): BankCardLoadingState()
    data class Error(val error: ResponseError) : BankCardLoadingState()
}