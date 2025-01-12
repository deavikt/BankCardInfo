package ru.salfa.data.local

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import kotlinx.coroutines.flow.Flow

@Dao
internal interface BankCardDao {

    @Query("SELECT * FROM `bank card`")
    fun getBankCards(): Flow<List<BankCardEntity>>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertBankCard(bankCardEntity: BankCardEntity)
}