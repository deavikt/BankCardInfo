package ru.salfa.bankcardinfo.ui.screens

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.text.input.TextFieldState
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import ru.salfa.bankcardinfo.ui.components.BINInfoCard
import ru.salfa.bankcardinfo.ui.components.BINInputField
import ru.salfa.bankcardinfo.ui.theme.BankCardInfoTheme

@Composable
fun BINInfoSearchScreen() {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(
                horizontal = 16.dp,
                vertical = 24.dp
            )
    ) {
        BINInputField(
            modifier = Modifier.fillMaxWidth(),
            state = TextFieldState()
        )
        BINInfoCard(
            modifier = Modifier
                .fillMaxWidth()
                .padding(top = 20.dp)
        )
    }
}

@Preview
@Composable
fun BINInfoSearchScreenPreview() {
    BankCardInfoTheme {
        BINInfoSearchScreen()
    }
}