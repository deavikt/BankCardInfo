package ru.salfa.data.mappers

import ru.salfa.data.remote.BankCardDto
import ru.salfa.domain.models.BankCard

internal class FromBankCardDtoToBankCardMapper {

    fun map(bankCard: BankCardDto): BankCard {
        return with(bankCard) {
            BankCard(
                bin = "",
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