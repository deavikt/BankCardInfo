package ru.salfa.bankcardinfo.ui.viewmodels

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch
import ru.salfa.data.repositories.BankCardRepository
import ru.salfa.bankcardinfo.ui.models.BankCardsLoadingState

class QueryHistoryViewModel(
    private val bankCardRepository: BankCardRepository
) : ViewModel() {
    private val bankCardsLoadingStateFlow: MutableStateFlow<BankCardsLoadingState> = MutableStateFlow(BankCardsLoadingState.Empty)

    init {
        getBankCardsFlow()
    }

    fun getBankCardsLoadingStateFlow(): StateFlow<BankCardsLoadingState> = bankCardsLoadingStateFlow

    private fun getBankCardsFlow() {
        viewModelScope.launch {
            bankCardRepository.getBankCardsFlow().collect { bankCards ->
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