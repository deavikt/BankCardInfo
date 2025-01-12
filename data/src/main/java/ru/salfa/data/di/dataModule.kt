package ru.salfa.data.di

import android.content.Context
import androidx.room.Room
import org.koin.core.module.Module
import org.koin.dsl.module
import ru.salfa.data.local.BankCardDao
import ru.salfa.data.local.BankCardDatabase
import ru.salfa.data.mappers.FromBankCardDtoToBankCardMapper
import ru.salfa.data.mappers.FromBankCardEntityToBankCardMapper
import ru.salfa.data.mappers.FromBankCardToBankCardEntityMapper
import ru.salfa.data.remote.BankCardApi
import ru.salfa.data.remote.RetrofitService
import ru.salfa.data.repositories.BankCardRepositoryImpl
import ru.salfa.domain.repositories.BankCardRepository

fun dataModule(appContext: Context): Module = module {

    val bankCardApi = RetrofitService().getRetrofit().create(BankCardApi::class.java)

    val database = Room.databaseBuilder(
        context = appContext,
        klass = BankCardDatabase::class.java,
        name = "bank cards"
    ).build()

    single<BankCardApi> { bankCardApi }
    single<BankCardDao> { database.bankCardDao() }

    single<FromBankCardToBankCardEntityMapper> { FromBankCardToBankCardEntityMapper() }
    single<FromBankCardDtoToBankCardMapper> { FromBankCardDtoToBankCardMapper() }
    single<FromBankCardEntityToBankCardMapper> { FromBankCardEntityToBankCardMapper() }

    single<BankCardRepository> { BankCardRepositoryImpl(get(), get(), get(), get(), get()) }
}