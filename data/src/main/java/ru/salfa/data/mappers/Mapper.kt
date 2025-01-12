package ru.salfa.data.mappers

internal interface Mapper<in T, out E> {
    fun map(bankCard: T): E
}