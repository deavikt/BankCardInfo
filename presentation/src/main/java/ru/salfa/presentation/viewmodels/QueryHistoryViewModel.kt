package ru.salfa.presentation.viewmodels

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch
import ru.salfa.domain.usecases.interfaces.GetBankCardsUseCase
import ru.salfa.presentation.models.BankCardsLoadingState

internal class QueryHistoryViewModel(
    private val getBankCardsUseCase: GetBankCardsUseCase
) : ViewModel() {
    private val bankCardsLoadingStateFlow: MutableStateFlow<BankCardsLoadingState> = MutableStateFlow(BankCardsLoadingState.Empty)

    init {
        getBankCardsFlow()
    }

    fun getBankCardsLoadingStateFlow(): StateFlow<BankCardsLoadingState> = bankCardsLoadingStateFlow

    private fun getBankCardsFlow() {
        viewModelScope.launch {
            getBankCardsUseCase().collect { bankCards ->
                if (bankCards.isEmpty()) {
                    bankCardsLoadingStateFlow.update {
                        BankCardsLoadingState.Empty
                    }
                } else {
                    bankCardsLoadingStateFlow.update {
                        BankCardsLoadingState.Success(bankCards)
                    }
                }
            }
        }
    }
}