package ru.salfa.data.mappers

import ru.salfa.data.remote.BankCardDto
import ru.salfa.domain.models.BankCardRemote

internal class FromDtoToRemoteBankCardMapper : Mapper<BankCardDto, BankCardRemote> {

    override fun map(bankCard: BankCardDto): BankCardRemote {
        return with(bankCard) {
            BankCardRemote(
                paymentSystem = scheme,
                countryName = country.name,
                countryLatitude = country.latitude,
                countryLongitude = country.longitude,
                bankName = bank?.name,
                bankUrl = bank?.url,
                bankPhone = bank?.phone,
                bankCity = bank?.city
            )
        }
    }
}