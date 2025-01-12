package ru.salfa.presentation.screens

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import org.koin.androidx.compose.koinViewModel
import ru.salfa.domain.models.ResponseError
import ru.salfa.presentation.components.AppButton
import ru.salfa.presentation.components.BinInfoCard
import ru.salfa.presentation.components.BinInputField
import ru.salfa.presentation.components.DataLoadingStateText
import ru.salfa.presentation.components.ProgressBar
import ru.salfa.presentation.models.BankCardLoadingState
import ru.salfa.presentation.R
import ru.salfa.presentation.theme.BankCardInfoTheme
import ru.salfa.presentation.viewmodels.BankCardSearchViewModel

@Composable
internal fun BankCardSearchScreen(
    viewModel: BankCardSearchViewModel = koinViewModel()
) {
    val searchButtonEnabledState by viewModel.getSearchButtonEnabledStateFlow().collectAsStateWithLifecycle()
    val bankCardLoadingState by viewModel.getBankCardLoadingStateFlow().collectAsStateWithLifecycle()

    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(
                horizontal = 16.dp,
                vertical = 24.dp
            )
    ) {
        Row(
            modifier = Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.spacedBy(20.dp)
        ) {
            BinInputField(
                modifier = Modifier.weight(1f),
                state = viewModel.getBinInputFieldState()
            )

            AppButton(
                onClick = { viewModel.getBankCardFlow() },
                modifier = Modifier,
                enabled = searchButtonEnabledState,
                textId = R.string.search_button_title
            )
        }

        Box(
            modifier = Modifier
                .fillMaxSize()
                .padding(top = 20.dp)
        ) {
            when (bankCardLoadingState) {
                is BankCardLoadingState.Empty -> { }

                is BankCardLoadingState.Loading -> {
                    ProgressBar(
                        modifier = Modifier.align(Alignment.Center)
                    )
                }

                is BankCardLoadingState.Success -> {
                    BinInfoCard(
                        modifier = Modifier.fillMaxWidth(),
                        bankCard = (bankCardLoadingState as BankCardLoadingState.Success).bankCard
                    )
                }

                is BankCardLoadingState.Error -> {
                    when ((bankCardLoadingState as BankCardLoadingState.Error).error) {
                        ResponseError.NotFound -> {
                            DataLoadingStateText(
                                stateTextId = R.string.bank_card_not_found_error_text,
                                modifier = Modifier.align(Alignment.Center)
                            )
                        }
                        ResponseError.FailedInternetConnection -> {
                            FailedInternetConnectionScreen(
                                repeatDataLoading = { viewModel.getBankCardFlow() }
                            )
                        }
                    }
                }
            }
        }
    }
}

@Preview
@Composable
private fun BankCardSearchScreenPreview() {
    BankCardInfoTheme {
        BankCardSearchScreen()
    }
}