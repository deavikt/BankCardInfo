package ru.salfa.presentation.mappers

import ru.salfa.domain.models.BankCard

internal class FromRemoteToLocalBankCardMapper {
    fun map(bankCard: BankCard, bin: String): BankCard {
        return with(bankCard) {
            BankCard(
                bin = bin,
                paymentSystem = paymentSystem,
                countryName = countryName,
                countryLatitude = countryLatitude,
                countryLongitude = countryLongitude,
                bankName = bankName,
                bankUrl = bankUrl,
                bankPhone = bankPhone,
                bankCity = bankCity
            )
        }
    }
}