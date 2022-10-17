package com.produtos.montaveis.network

import com.produtos.montaveis.model.Student
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

private val retrofit = Retrofit.Builder()
    .addConverterFactory(MoshiConverterFactory.create(moshi))
    .baseUrl(BASE_URL)
    .build()

interface StudentApiService {
    @GET("students/{studentId}")
    suspend fun getStudent(@Path("studentId") studentId: Long): Student
}

object StudentApi {
    val retrofitService: StudentApiService by lazy {
        retrofit.create(StudentApiService::class.java)
    }
}