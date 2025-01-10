package ru.salfa.bankcardinfo.data.mappers

interface Mapper<in T, out E> {
    fun map(bankCard: T, bin: String): E
}