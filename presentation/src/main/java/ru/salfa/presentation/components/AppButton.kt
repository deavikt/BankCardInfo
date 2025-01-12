package ru.salfa.presentation.components

import androidx.annotation.StringRes
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonColors
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import ru.salfa.presentation.R
import ru.salfa.presentation.theme.BankCardInfoTheme
import ru.salfa.presentation.theme.DisabledContainer
import ru.salfa.presentation.theme.DisabledContent
import ru.salfa.presentation.theme.Purple
import ru.salfa.presentation.theme.Typography
import ru.salfa.presentation.theme.White

@Composable
internal fun AppButton(
    onClick: () -> Unit,
    modifier: Modifier,
    enabled: Boolean = true,
    @StringRes textId: Int
) {
    Button(
        onClick = onClick,
        modifier = modifier,
        enabled = enabled,
        shape = RoundedCornerShape(16.dp),
        colors = ButtonColors(
            containerColor = Purple,
            contentColor = White,
            disabledContainerColor = DisabledContainer,
            disabledContentColor = DisabledContent
        )
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
            enabled = false,
            textId = R.string.search_button_title
        )
    }
}