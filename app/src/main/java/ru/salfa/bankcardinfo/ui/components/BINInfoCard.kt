package ru.salfa.bankcardinfo.ui.components

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import ru.salfa.bankcardinfo.R
import ru.salfa.bankcardinfo.ui.theme.BankCardInfoTheme
import ru.salfa.bankcardinfo.ui.theme.DisabledContainer
import ru.salfa.bankcardinfo.ui.theme.Typography

@Composable
fun BINInfoCard(modifier: Modifier) {
    Column(
        modifier = modifier
            .background(
                color = DisabledContainer,
                shape = RoundedCornerShape(16.dp)
            )
            .padding(20.dp),
        verticalArrangement = Arrangement.spacedBy(4.dp)
    ) {
        BankCardProperty(R.string.country_title, "Германия")
        BankCardProperty(R.string.coordinates_title, "56 10")
        BankCardProperty(R.string.payment_system_type_title, "visa")
        BankCardProperty(R.string.bank_title, "Jyske Bank")
        BankCardProperty(R.string.url_title, "www.jyskebank.dk")
        BankCardProperty(R.string.phone_title, "+4589893300")
        BankCardProperty(R.string.city_title, "Hjorring")
    }
}

@Composable
private fun BankCardProperty(
    propertyNameId: Int,
    propertyText: String
) {
    Row {
        BankCardPropertyName(stringResource(propertyNameId))
        BankCardPropertyText(propertyText)
    }
}

@Composable
private fun BankCardPropertyName(propertyName: String) {
    Text(
        text = "$propertyName:",
        style = Typography.bodyMedium
    )
}

@Composable
private fun BankCardPropertyText(propertyText: String) {
    Text(
        text = propertyText,
        modifier = Modifier.padding(start = 4.dp),
        style = Typography.bodySmall
    )
}

@Preview
@Composable
private fun BINInfoCardPreview() {
    BankCardInfoTheme {
        BINInfoCard(Modifier.fillMaxWidth())
    }
}