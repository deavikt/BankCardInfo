package ru.salfa.bankcardinfo.ui.models

import ru.salfa.data.local.BankCardEntity

sealed class BankCardsLoadingState {
    data object Empty : BankCardsLoadingState()
    data class Success(val bankCards: List<BankCardEntity>) : BankCardsLoadingState()
}