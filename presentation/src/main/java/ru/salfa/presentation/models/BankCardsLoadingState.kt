package ru.salfa.presentation.models

import ru.salfa.domain.models.BankCard

internal sealed class BankCardsLoadingState {
    data object Empty : BankCardsLoadingState()
    data class Success(val bankCards: List<BankCard>) : BankCardsLoadingState()
}