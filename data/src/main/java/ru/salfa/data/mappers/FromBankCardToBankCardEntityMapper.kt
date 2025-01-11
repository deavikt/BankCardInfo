package ru.salfa.data.mappers

import ru.salfa.data.local.BankCardEntity
import ru.salfa.data.models.BankCard

internal class FromBankCardToBankCardEntityMapper {

    fun map(bankCard: BankCard, bin: String): BankCardEntity {
        return with(bankCard) {
            BankCardEntity(
                bin = bin,
                paymentSystem = scheme,
                countryName = country.name,
                countryLatitude = country.latitude,
                countryLongitude = country.longitude,
                bankName = bank.name,
                bankUrl = bank.url,
                bankPhone = bank.phone,
                bankCity = bank.city
            )
        }
    }
}