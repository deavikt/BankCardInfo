package ru.salfa.presentation.models

import ru.salfa.domain.models.BankCardLocal

internal sealed class BankCardsLoadingState {
    data object Empty : BankCardsLoadingState()
    data class Success(val bankCards: List<BankCardLocal>) : BankCardsLoadingState()
}