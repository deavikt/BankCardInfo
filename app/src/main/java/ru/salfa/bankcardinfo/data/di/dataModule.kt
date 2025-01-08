package ru.salfa.bankcardinfo.data.di

import org.koin.core.module.Module
import org.koin.dsl.module
import ru.salfa.bankcardinfo.data.network.BankCardApi
import ru.salfa.bankcardinfo.data.network.RetrofitService
import ru.salfa.bankcardinfo.data.repositories.BankCardRepository

fun dataModule(): Module = module {
    val bankCardApi = RetrofitService().getRetrofit().create(BankCardApi::class.java)

    single<BankCardApi> { bankCardApi }
    single<BankCardRepository> { BankCardRepository(get()) }
}