package ru.salfa.bankcardinfo.ui.components

import android.content.Context
import android.content.Intent
import android.net.Uri
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import ru.salfa.bankcardinfo.R
import ru.salfa.bankcardinfo.data.local.BankCardEntity
import ru.salfa.bankcardinfo.ui.models.BIN
import ru.salfa.bankcardinfo.ui.theme.BankCardInfoTheme
import ru.salfa.bankcardinfo.ui.theme.DisabledContainer
import ru.salfa.bankcardinfo.ui.theme.Typography

@Composable
fun BankCard(
    modifier: Modifier,
    bankCard: BankCardEntity
) {
    val context = LocalContext.current

    Column(
        modifier = modifier
            .background(
                color = DisabledContainer,
                shape = RoundedCornerShape(16.dp)
            )
            .padding(20.dp),
        verticalArrangement = Arrangement.spacedBy(4.dp)
    ) {
        BankCardProperty(
            modifier = Modifier,
            propertyNameId = R.string.bin_title,
            propertyText = getFormattedBin(bankCard.bin)
        )

        BankCardProperty(
            modifier = Modifier,
            propertyNameId = R.string.country_title,
            propertyText = bankCard.countryName
        )

        BankCardProperty(
            modifier = Modifier.clickable {
                openMap(
                    context = context,
                    latitude = bankCard.countryLatitude,
                    longitude = bankCard.countryLongitude
                )
            },
            propertyNameId = R.string.coordinates_title,
            propertyText = "${bankCard.countryLatitude}, ${bankCard.countryLongitude}"
        )

        BankCardProperty(
            modifier = Modifier,
            propertyNameId = R.string.payment_system_type_title,
            propertyText = bankCard.paymentSystem.replaceFirstChar { char -> char.uppercase() }
        )

        BankCardProperty(
            modifier = Modifier,
            propertyNameId = R.string.bank_title,
            propertyText = bankCard.bankName
        )

        bankCard.bankUrl?.let { url ->
            BankCardProperty(
                modifier = Modifier,
                propertyNameId = R.string.url_title,
                propertyText = url
            )
        }

        bankCard.bankPhone?.let { phone ->
            BankCardProperty(
                modifier = Modifier,
                propertyNameId = R.string.phone_title,
                propertyText = phone
            )
        }

        bankCard.bankCity?.let { city ->
            BankCardProperty(
                modifier = Modifier,
                propertyNameId = R.string.city_title,
                propertyText = city
            )
        }
    }
}

@Composable
private fun BankCardProperty(
    modifier: Modifier,
    propertyNameId: Int,
    propertyText: String
) {
    Row(modifier = modifier) {
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

private fun getFormattedBin(bin: String): String {
    val formattedBin: StringBuilder = StringBuilder()
    formattedBin.append(bin)

    BIN.MASK.forEachIndexed { index, char ->
        if (char == ' ') {
            formattedBin.insert(index, char)
        }
    }

    return formattedBin.toString()
}

private fun openMap(
    context: Context,
    latitude: Int,
    longitude: Int
) {
    val intent = Intent(Intent.ACTION_VIEW).apply {
        data = Uri.parse("geo:$latitude, $longitude")
        flags = Intent.FLAG_ACTIVITY_NEW_TASK
    }
    
    context.applicationContext.startActivity(intent)
}

@Preview
@Composable
private fun BankCardPreview() {
    BankCardInfoTheme {
        BankCard(
            modifier = Modifier.fillMaxWidth(),
            bankCard = BankCardEntity(
                bin = "45717360",
                paymentSystem = "visa",
                countryName = "Германия",
                countryLatitude = 56,
                countryLongitude = 10,
                bankName = "Jyske Bank",
                bankUrl = "www.jyskebank.dk",
                bankPhone = "+4589893300",
                bankCity = "Hjorring"
            )
        )
    }
}