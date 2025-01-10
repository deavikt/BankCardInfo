package ru.salfa.bankcardinfo.data.local

import androidx.room.Database
import androidx.room.RoomDatabase

@Database(entities = [BankCardEntity::class], version = 1)
abstract class BankCardDatabase: RoomDatabase() {
    abstract fun bankCardDao(): BankCardDao
}