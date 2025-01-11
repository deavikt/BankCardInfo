package ru.salfa.bankcardinfo.ui.models

import ru.salfa.data.models.BankCard
import ru.salfa.data.models.ResponseError

sealed class BankCardLoadingState {
    data object Empty : BankCardLoadingState()
    data object Loading : BankCardLoadingState()
    data class Success(val bankCard: BankCard): BankCardLoadingState()
    data class Error(val error: ResponseError) : BankCardLoadingState()
}