package ru.salfa.presentation.models

import ru.salfa.data.local.BankCardEntity

internal sealed class BankCardsLoadingState {
    data object Empty : BankCardsLoadingState()
    data class Success(val bankCards: List<BankCardEntity>) : BankCardsLoadingState()
}