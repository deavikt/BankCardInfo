package ru.salfa.bankcardinfo.ui.viewmodels

import androidx.compose.foundation.text.input.TextFieldState
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch
import ru.salfa.bankcardinfo.data.models.ResponseResult
import ru.salfa.bankcardinfo.data.repositories.BankCardRepository
import ru.salfa.bankcardinfo.ui.models.BIN
import ru.salfa.bankcardinfo.ui.models.BankCardLoadingState

class BankCardSearchViewModel(
    private val bankCardRepository: BankCardRepository
) : ViewModel() {
    private val binInputFieldState: TextFieldState = TextFieldState()
    private val searchButtonEnabledState: MutableStateFlow<Boolean> = MutableStateFlow(false)
    private val bankCardLoadingStateFlow: MutableStateFlow<BankCardLoadingState> = MutableStateFlow(BankCardLoadingState.Empty)

    fun getBinInputFieldState(): TextFieldState = binInputFieldState

    fun getBankCardFlow() {
        bankCardLoadingStateFlow.update { BankCardLoadingState.Loading }

        viewModelScope.launch {
            bankCardRepository.getBankCardFlow(binInputFieldState.text.toString())
                .collect { response ->
                    when (response) {
                        is ResponseResult.Success -> {
                            bankCardLoadingStateFlow.update {
                                BankCardLoadingState.Success(response.data)
                            }
                        }
                        is ResponseResult.Error -> {
                            bankCardLoadingStateFlow.update {
                                BankCardLoadingState.Error(response.error)
                            }
                        }
                    }
                }
        }
    }

    fun getSearchButtonEnabledStateFlow(): StateFlow<Boolean> {
        return searchButtonEnabledState.apply {
            update { binInputFieldState.text.length >= BIN.MIN_LENGTH }
        }
    }

    fun getBankCardLoadingStateFlow(): StateFlow<BankCardLoadingState> = bankCardLoadingStateFlow
}