package ru.salfa.presentation.components

import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import ru.salfa.presentation.theme.BankCardInfoTheme
import ru.salfa.presentation.theme.Purple
import ru.salfa.presentation.theme.White

@Composable
internal fun ProgressBar(modifier: Modifier) {
    CircularProgressIndicator(
        modifier = modifier,
        color = White,
        strokeWidth = 5.dp,
        trackColor = Purple
    )
}

@Preview
@Composable
private fun ProgressBarPreview() {
    BankCardInfoTheme {
        ProgressBar(Modifier)
    }
}