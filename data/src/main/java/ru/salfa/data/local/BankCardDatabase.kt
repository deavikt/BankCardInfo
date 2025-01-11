package ru.salfa.data.local

import androidx.room.Database
import androidx.room.RoomDatabase

@Database(entities = [BankCardEntity::class], version = 1)
internal abstract class BankCardDatabase: RoomDatabase() {
    abstract fun bankCardDao(): BankCardDao
}