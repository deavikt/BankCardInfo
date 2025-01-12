package ru.salfa.presentation.mappers

import ru.salfa.domain.models.BankCardLocal
import ru.salfa.domain.models.BankCardRemote

internal class FromRemoteToLocalBankCardMapper {
    fun map(bankCard: BankCardRemote, bin: String): BankCardLocal {
        return with(bankCard) {
            BankCardLocal(
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