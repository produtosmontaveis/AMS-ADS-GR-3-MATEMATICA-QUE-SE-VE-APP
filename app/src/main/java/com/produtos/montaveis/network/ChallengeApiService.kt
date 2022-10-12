package com.produtos.montaveis.network

import com.produtos.montaveis.model.Challenge
import com.squareup.moshi.Moshi
import com.squareup.moshi.kotlin.reflect.KotlinJsonAdapterFactory
import retrofit2.Retrofit
import retrofit2.converter.moshi.MoshiConverterFactory
import retrofit2.http.GET
import retrofit2.http.Path

private const val BASE_URL = "https://pm-challenges-api.herokuapp.com/"

private val moshi = Moshi.Builder()
    .add(KotlinJsonAdapterFactory())
    .build()

/**
 * The Retrofit object with the Moshi converter.
 */
private val retrofit = Retrofit.Builder()
    .addConverterFactory(MoshiConverterFactory.create(moshi))
    .baseUrl(BASE_URL)
    .build()

interface ChallengeApiService {
    @GET("students/{studentId}/challenges")
    suspend fun getChallenges(@Path("studentId") studentId: Long): List<Challenge>
}

object ChallengeApi {
    val retrofitService: ChallengeApiService by lazy {
        retrofit.create(ChallengeApiService::class.java)
    }
}