package ru.salfa.bankcardinfo.ui.screens

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import ru.salfa.bankcardinfo.R
import ru.salfa.bankcardinfo.ui.components.AppButton
import ru.salfa.bankcardinfo.ui.theme.BankCardInfoTheme
import ru.salfa.bankcardinfo.ui.theme.Typography

@Composable
fun FailedInternetConnectionScreen(
    repeatDataLoading: () -> Unit
) {
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
        Image(
            painter = painterResource(R.drawable.failed_internet_connection_icon),
            contentDescription = stringResource(R.string.failed_internet_connection_icon_description),
            modifier = Modifier.size(100.dp)
        )

        Text(
            text = stringResource(R.string.failed_internet_connection_error_text),
            modifier = Modifier.padding(top = 8.dp),
            textAlign = TextAlign.Center,
            style = Typography.bodySmall
        )

        AppButton(
            onClick = repeatDataLoading,
            modifier = Modifier.padding(top = 36.dp),
            textId = R.string.repeat_button_title
        )
    }
}

@Preview
@Composable
private fun FailedInternetConnectionScreenPreview() {
    BankCardInfoTheme {
        FailedInternetConnectionScreen(
            repeatDataLoading = { }
        )
    }
}