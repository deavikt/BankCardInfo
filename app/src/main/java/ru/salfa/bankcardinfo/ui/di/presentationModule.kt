package ru.salfa.bankcardinfo.ui.di

import org.koin.core.module.dsl.viewModel
import org.koin.dsl.module
import ru.salfa.bankcardinfo.ui.viewmodels.BankCardSearchViewModel

val presentationModule = module {
    viewModel { BankCardSearchViewModel(get()) }
}