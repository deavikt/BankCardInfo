package ru.salfa.bankcardinfo.data.local

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import kotlinx.coroutines.flow.Flow

@Dao
interface BankCardDao {

    @Query("SELECT * FROM `bank card`")
    fun getBankCards(): Flow<List<BankCardEntity>>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertBankCard(bankCardEntity: BankCardEntity)
}