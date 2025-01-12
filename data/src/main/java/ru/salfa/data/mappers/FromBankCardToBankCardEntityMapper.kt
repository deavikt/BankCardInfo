package ru.salfa.data.mappers

import ru.salfa.data.local.BankCardEntity
import ru.salfa.domain.models.BankCard

internal class FromBankCardToBankCardEntityMapper {

    fun map(bankCard: BankCard): BankCardEntity {
        return with(bankCard) {
            BankCardEntity(
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