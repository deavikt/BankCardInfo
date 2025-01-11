package ru.salfa.presentation.di

import org.koin.core.module.dsl.viewModel
import org.koin.dsl.module
import ru.salfa.presentation.viewmodels.BankCardSearchViewModel
import ru.salfa.presentation.viewmodels.QueryHistoryViewModel

val presentationModule = module {
    viewModel { BankCardSearchViewModel(get()) }
    viewModel { QueryHistoryViewModel(get()) }
}