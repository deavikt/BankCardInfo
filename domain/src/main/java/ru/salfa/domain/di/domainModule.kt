package ru.salfa.domain.di

import org.koin.dsl.module
import ru.salfa.domain.usecases.implementation.GetBankCardUseCaseImpl
import ru.salfa.domain.usecases.implementation.InsertBankCardUseCaseImpl
import ru.salfa.domain.usecases.interfaces.GetBankCardUseCase
import ru.salfa.domain.usecases.interfaces.InsertBankCardUseCase

val domainModule = module {
    factory<GetBankCardUseCase> { GetBankCardUseCaseImpl(get()) }
    factory<InsertBankCardUseCase> { InsertBankCardUseCaseImpl(get()) }
}