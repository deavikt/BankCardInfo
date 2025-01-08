package ru.salfa.bankcardinfo.data.models

data class BankCard(
    val scheme: String,
    val country: Country,
    val bank: Bank
) {
    data class Bank(
        val name: String,
        val url: String,
        val phone: String,
        val city: String
    )

    data class Country(
        val name: String,
        val latitude: Int,
        val longitude: Int
    )
}