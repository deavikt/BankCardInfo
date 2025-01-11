package ru.salfa.data.remote

import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Headers
import retrofit2.http.Path
import ru.salfa.data.models.BankCard

internal interface BankCardApi {

    @Headers("Accept-Version: 3")
    @GET("{bin}")
    suspend fun getBankCard(@Path("bin") bin: String): Response<BankCard>
}