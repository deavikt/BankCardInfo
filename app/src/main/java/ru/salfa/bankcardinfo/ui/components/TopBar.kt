package ru.salfa.bankcardinfo.ui.components

import androidx.annotation.StringRes
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import ru.salfa.bankcardinfo.R
import ru.salfa.bankcardinfo.ui.theme.BankCardInfoTheme
import ru.salfa.bankcardinfo.ui.theme.Typography

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun TopBar(@StringRes titleId: Int) {
    TopAppBar(
        title = {
            Text(
                text = stringResource(titleId),
                style = Typography.titleLarge
            )
        }
    )
}

@Preview
@Composable
private fun TopBarPreview() {
    BankCardInfoTheme {
        TopBar(
            titleId = R.string.bank_card_search_title
        )
    }
}