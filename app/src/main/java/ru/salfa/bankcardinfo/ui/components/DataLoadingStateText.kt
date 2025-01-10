package ru.salfa.bankcardinfo.ui.components

import androidx.annotation.StringRes
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import ru.salfa.bankcardinfo.R
import ru.salfa.bankcardinfo.ui.theme.BankCardInfoTheme
import ru.salfa.bankcardinfo.ui.theme.Hint
import ru.salfa.bankcardinfo.ui.theme.Typography

@Composable
fun DataLoadingStateText(
    @StringRes stateTextId: Int,
    modifier: Modifier
) {
    Text(
        text = stringResource(stateTextId),
        modifier = modifier,
        textAlign = TextAlign.Center,
        style = Typography.bodyMedium.copy(color = Hint)
    )
}

@Preview
@Composable
private fun DataLoadingStateTextPreview() {
    BankCardInfoTheme {
        DataLoadingStateText(
            stateTextId = R.string.empty_query_history_text,
            modifier = Modifier
        )
    }
}