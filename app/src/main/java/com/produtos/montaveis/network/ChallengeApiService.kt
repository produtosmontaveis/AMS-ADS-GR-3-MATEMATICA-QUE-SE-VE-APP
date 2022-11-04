package com.produtos.montaveis.network

import com.produtos.montaveis.model.Challenge
import com.squareup.moshi.Moshi
import com.squareup.moshi.kotlin.reflect.KotlinJsonAdapterFactory
import retrofit2.Retrofit
import retrofit2.converter.moshi.MoshiConverterFactory
import retrofit2.http.GET

// Base url for http request on heroku
//private const val BASE_URL = "https://pm-challenges-api.herokuapp.com/"

// Base url for local request on emulator
private const val BASE_URL = "http://10.0.2.2:8080/"

// Base url for local request on physical device
//private const val BASE_URL = "http://192.168.1.10:8080"

private val moshi = Moshi.Builder()
    .add(KotlinJsonAdapterFactory())
    .build()

private val retrofit = Retrofit.Builder()
    .addConverterFactory(MoshiConverterFactory.create(moshi))
    .baseUrl(BASE_URL)
    .build()

interface ChallengeApiService {

    @GET("students/1/challenges")
    suspend fun getChallenges(): List<Challenge>
}

object ChallengeApi {
    val retrofitService: ChallengeApiService by lazy {
        retrofit.create(ChallengeApiService::class.java)
    }
}