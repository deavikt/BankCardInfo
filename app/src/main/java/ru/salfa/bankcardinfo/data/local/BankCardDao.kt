package ru.salfa.bankcardinfo.data.local

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query
import kotlinx.coroutines.flow.Flow

@Dao
interface BankCardDao {

    @Query("SELECT * FROM `bank card`")
    fun getBankCards(): Flow<List<BankCardEntity>>

    @Insert
    suspend fun insertBankCard(bankCardEntity: BankCardEntity)
}