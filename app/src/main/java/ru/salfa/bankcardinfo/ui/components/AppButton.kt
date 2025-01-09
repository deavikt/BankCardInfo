package ru.salfa.bankcardinfo.ui.components

import androidx.annotation.StringRes
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import ru.salfa.bankcardinfo.R
import ru.salfa.bankcardinfo.ui.theme.BankCardInfoTheme
import ru.salfa.bankcardinfo.ui.theme.Typography

@Composable
fun AppButton(
    onClick: () -> Unit,
    modifier: Modifier,
    @StringRes textId: Int
) {
    Button(
        onClick = onClick,
        modifier = modifier,
        shape = RoundedCornerShape(16.dp)
    ) {
        Text(
            text = stringResource(textId),
            modifier = Modifier
                .padding(
                    top = 8.dp,
                    start = 18.dp,
                    end = 18.dp,
                    bottom = 9.dp
                ),
            style = Typography.bodyMedium
        )
    }
}

@Preview
@Composable
private fun AppButtonPreview() {
    BankCardInfoTheme {
        AppButton(
            onClick = { },
            modifier = Modifier,
            textId = R.string.search_button_title
        )
    }
}