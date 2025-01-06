package ru.salfa.bankcardinfo.ui.components

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.BasicTextField
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.foundation.text.input.InputTransformation
import androidx.compose.foundation.text.input.TextFieldState
import androidx.compose.foundation.text.input.insert
import androidx.compose.foundation.text.input.maxLength
import androidx.compose.foundation.text.input.then
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.core.text.isDigitsOnly
import ru.salfa.bankcardinfo.ui.theme.BankCardInfoTheme
import ru.salfa.bankcardinfo.ui.theme.DisabledContainer
import ru.salfa.bankcardinfo.ui.theme.Hint
import ru.salfa.bankcardinfo.ui.theme.Typography

@Composable
fun BINInputField(
    modifier: Modifier,
    state: TextFieldState
) {
    Box(
        modifier = modifier
            .background(
                color = DisabledContainer,
                shape = RoundedCornerShape(16.dp)
            )
            .padding(
                top = 16.dp,
                start = 20.dp,
                end = 20.dp,
                bottom = 17.dp
            ),
        contentAlignment = Alignment.CenterEnd
    ) {
        BasicTextField(
            state = state,
            inputTransformation = InputTransformation
                .maxLength(8)
                .then {
                    if (!asCharSequence().isDigitsOnly()) {
                        revertAllChanges()
                    }
                },
            outputTransformation = {
                if (length > 4) {
                    insert(4, " ")
                }
            },
            textStyle = Typography.bodyMedium.copy(textAlign = TextAlign.End),
            keyboardOptions = KeyboardOptions(
                keyboardType = KeyboardType.Number
            )
        )

        if (state.text.isEmpty()) {
            Text(
                text = "0000 0000",
                style = Typography.bodyMedium.copy(color = Hint)
            )
        }
    }
}

@Preview
@Composable
fun BINInputFieldPreview() {
    BankCardInfoTheme {
        BINInputField(
            modifier = Modifier.fillMaxWidth(),
            state = TextFieldState()
        )
    }
}