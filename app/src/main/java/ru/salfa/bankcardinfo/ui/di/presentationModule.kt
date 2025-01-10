package ru.salfa.bankcardinfo.ui.di

import org.koin.core.module.dsl.viewModel
import org.koin.dsl.module
import ru.salfa.bankcardinfo.ui.viewmodels.BankCardSearchViewModel
import ru.salfa.bankcardinfo.ui.viewmodels.QueryHistoryViewModel

val presentationModule = module {
    viewModel { BankCardSearchViewModel(get()) }
    viewModel { QueryHistoryViewModel(get()) }
}