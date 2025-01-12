package ru.salfa.data.mappers

import ru.salfa.data.local.BankCardEntity
import ru.salfa.domain.models.BankCardLocal

internal class FromLocalToEntityBankCardMapper : Mapper<BankCardLocal, BankCardEntity> {

    override fun map(bankCard: BankCardLocal): BankCardEntity {
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