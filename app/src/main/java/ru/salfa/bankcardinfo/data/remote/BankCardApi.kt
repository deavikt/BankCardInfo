package ru.salfa.bankcardinfo.data.remote

import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Headers
import retrofit2.http.Path
import ru.salfa.bankcardinfo.data.models.BankCard

interface BankCardApi {

    @Headers("Accept-Version: 3")
    @GET("{bin}")
    suspend fun getBankCard(@Path("bin") bin: String): Response<BankCard>
}