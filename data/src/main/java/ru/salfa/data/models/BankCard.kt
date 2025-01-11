package ru.salfa.data.models

internal data class BankCard(
    val number: Number?,
    val scheme: String,
    val country: Country,
    val bank: Bank
) {
    data class Number(
        val length: Int
    )

    data class Bank(
        val name: String,
        val url: String?,
        val phone: String?,
        val city: String?
    )

    data class Country(
        val name: String,
        val latitude: Int,
        val longitude: Int
    )
}