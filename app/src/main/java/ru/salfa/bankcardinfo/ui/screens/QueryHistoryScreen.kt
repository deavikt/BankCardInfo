package ru.salfa.bankcardinfo.ui.screens

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import ru.salfa.bankcardinfo.R
import ru.salfa.bankcardinfo.ui.theme.BankCardInfoTheme
import ru.salfa.bankcardinfo.ui.theme.Hint
import ru.salfa.bankcardinfo.ui.theme.Typography

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
        Text(
            text = stringResource(R.string.empty_query_history_text),
            style = Typography.bodyMedium.copy(color = Hint)
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