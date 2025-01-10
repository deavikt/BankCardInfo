package ru.salfa.bankcardinfo.ui.screens

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import org.koin.androidx.compose.koinViewModel
import ru.salfa.bankcardinfo.R
import ru.salfa.bankcardinfo.data.local.BankCardEntity
import ru.salfa.bankcardinfo.ui.components.BINQueryHistoryCard
import ru.salfa.bankcardinfo.ui.components.DataLoadingStateText
import ru.salfa.bankcardinfo.ui.models.BankCardsLoadingState
import ru.salfa.bankcardinfo.ui.theme.BankCardInfoTheme
import ru.salfa.bankcardinfo.ui.viewmodels.QueryHistoryViewModel

@Composable
fun QueryHistoryScreen(
    viewModel: QueryHistoryViewModel = koinViewModel()
) {
    val bankCardsLoadingState by viewModel.getBankCardsLoadingStateFlow().collectAsStateWithLifecycle()

    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(
                horizontal = 16.dp,
                vertical = 24.dp
            ),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        when (bankCardsLoadingState) {
            is BankCardsLoadingState.Empty -> {
                DataLoadingStateText(
                    stateTextId = R.string.empty_query_history_text,
                    modifier = Modifier
                )
            }
            is BankCardsLoadingState.Success -> {
                BankCardList((bankCardsLoadingState as BankCardsLoadingState.Success).bankCards)
            }
        }
    }
}

@Composable
private fun BankCardList(bankCards: List<BankCardEntity>) {
    LazyColumn(
        modifier = Modifier.fillMaxSize()
    ) {
        items(bankCards.size) { index ->
            BINQueryHistoryCard(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(bottom = 10.dp),
                bankCard = bankCards[index]
            )
        }
    }
}

@Preview
@Composable
private fun QueryHistoryScreenPreview() {
    BankCardInfoTheme {
        QueryHistoryScreen()
    }
}