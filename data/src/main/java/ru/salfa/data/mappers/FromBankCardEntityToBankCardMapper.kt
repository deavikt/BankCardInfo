package ru.salfa.data.mappers

import ru.salfa.data.local.BankCardEntity
import ru.salfa.domain.models.BankCard

internal class FromBankCardEntityToBankCardMapper {

    fun map(bankCard: BankCardEntity): BankCard {
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