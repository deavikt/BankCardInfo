package ru.salfa.presentation.viewmodels

import androidx.compose.foundation.text.input.TextFieldState
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch
import ru.salfa.domain.models.ResponseResult
import ru.salfa.domain.usecases.interfaces.GetBankCardUseCase
import ru.salfa.domain.usecases.interfaces.InsertBankCardUseCase
import ru.salfa.presentation.mappers.FromRemoteToLocalBankCardMapper
import ru.salfa.presentation.models.BIN
import ru.salfa.presentation.models.BankCardLoadingState

internal class BankCardSearchViewModel(
    private val getBankCardUseCase: GetBankCardUseCase,
    private val insertBankCardUseCase: InsertBankCardUseCase,
    private val fromRemoteToLocalBankCardMapper: FromRemoteToLocalBankCardMapper
) : ViewModel() {
    private val binInputFieldState: TextFieldState = TextFieldState()
    private val searchButtonEnabledState: MutableStateFlow<Boolean> = MutableStateFlow(false)
    private val bankCardLoadingStateFlow: MutableStateFlow<BankCardLoadingState> = MutableStateFlow(BankCardLoadingState.Empty)

    fun getBinInputFieldState(): TextFieldState = binInputFieldState

    fun getBankCardFlow() {
        bankCardLoadingStateFlow.update { BankCardLoadingState.Loading }

        viewModelScope.launch {
            getBankCardUseCase(binInputFieldState.text.toString())
                .collect { response ->
                    when (response) {
                        is ResponseResult.Success -> {
                            bankCardLoadingStateFlow.update {
                                BankCardLoadingState.Success(response.data)
                            }

                            insertBankCardUseCase(
                                fromRemoteToLocalBankCardMapper.map(
                                    bankCard = response.data,
                                    bin = binInputFieldState.text.toString()
                                )
                            )
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