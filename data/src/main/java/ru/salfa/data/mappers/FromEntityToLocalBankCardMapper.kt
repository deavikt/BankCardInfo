package ru.salfa.data.mappers

import ru.salfa.data.local.BankCardEntity
import ru.salfa.domain.models.BankCardLocal

internal class FromEntityToLocalBankCardMapper : Mapper<BankCardEntity, BankCardLocal> {

    override fun map(bankCard: BankCardEntity): BankCardLocal {
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