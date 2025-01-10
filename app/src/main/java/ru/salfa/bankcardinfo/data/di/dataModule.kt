package ru.salfa.bankcardinfo.data.di

import android.content.Context
import androidx.room.Room
import org.koin.core.module.Module
import org.koin.dsl.module
import ru.salfa.bankcardinfo.data.local.BankCardDao
import ru.salfa.bankcardinfo.data.local.BankCardDatabase
import ru.salfa.bankcardinfo.data.remote.BankCardApi
import ru.salfa.bankcardinfo.data.remote.RetrofitService
import ru.salfa.bankcardinfo.data.repositories.BankCardRepository

fun dataModule(appContext: Context): Module = module {
    val bankCardApi = RetrofitService().getRetrofit().create(BankCardApi::class.java)

    val database = Room.databaseBuilder(
        context = appContext,
        klass = BankCardDatabase::class.java,
        name = "bank cards"
    ).build()

    single<BankCardApi> { bankCardApi }
    single<BankCardDao> { database.bankCardDao() }

    single<BankCardRepository> { BankCardRepository(get()) }
}