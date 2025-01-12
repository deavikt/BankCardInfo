package ru.salfa.domain.models

data class BankCardLocal(
    val bin: String,
    val paymentSystem: String,
    val countryName: String,
    val countryLatitude: Int,
    val countryLongitude: Int,
    val bankName: String,
    val bankUrl: String?,
    val bankPhone: String?,
    val bankCity: String?
)