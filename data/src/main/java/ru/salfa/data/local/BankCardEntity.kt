package ru.salfa.data.local

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "bank card")
internal data class BankCardEntity(
    @PrimaryKey val bin: String,
    @ColumnInfo val paymentSystem: String,
    @ColumnInfo val countryName: String,
    @ColumnInfo val countryLatitude: Int,
    @ColumnInfo val countryLongitude: Int,
    @ColumnInfo val bankName: String,
    @ColumnInfo val bankUrl: String?,
    @ColumnInfo val bankPhone: String?,
    @ColumnInfo val bankCity: String?
)