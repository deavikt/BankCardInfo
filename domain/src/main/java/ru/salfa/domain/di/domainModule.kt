package ru.salfa.domain.di

import org.koin.dsl.module
import ru.salfa.domain.usecases.implementation.GetBankCardUseCaseImpl
import ru.salfa.domain.usecases.interfaces.GetBankCardUseCase

val domainModule = module {
    factory<GetBankCardUseCase> { GetBankCardUseCaseImpl(get()) }
}