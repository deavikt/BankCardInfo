package ru.salfa.bankcardinfo.data.mappers

import ru.salfa.bankcardinfo.data.local.BankCardEntity
import ru.salfa.bankcardinfo.data.models.BankCard

class BankCardMapper: Mapper<BankCard, BankCardEntity> {

    override fun map(bankCard: BankCard, bin: String): BankCardEntity {
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