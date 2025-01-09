package ru.salfa.bankcardinfo.ui.screens

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import ru.salfa.bankcardinfo.R
import ru.salfa.bankcardinfo.ui.components.DataLoadingStateText
import ru.salfa.bankcardinfo.ui.theme.BankCardInfoTheme

@Composable
fun QueryHistoryScreen() {
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
        DataLoadingStateText(
            stateTextId = R.string.empty_query_history_text,
            modifier = Modifier
        )
    }
}

@Preview
@Composable
private fun QueryHistoryScreenPreview() {
    BankCardInfoTheme {
        QueryHistoryScreen()
    }
}