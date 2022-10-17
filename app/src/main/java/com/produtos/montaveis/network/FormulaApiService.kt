package com.produtos.montaveis.network

import com.squareup.moshi.Moshi
import com.squareup.moshi.kotlin.reflect.KotlinJsonAdapterFactory
import okhttp3.ResponseBody
import retrofit2.Call
import retrofit2.Retrofit
import retrofit2.converter.moshi.MoshiConverterFactory
import retrofit2.http.GET
import retrofit2.http.Path

private const val BASE_URL = "https://formulas-api.herokuapp.com/"

private val moshi = Moshi.Builder()
    .add(KotlinJsonAdapterFactory())
    .build()

private val retrofit = Retrofit.Builder()
    .addConverterFactory(MoshiConverterFactory.create(moshi))
    .baseUrl(BASE_URL)
    .build()

interface FormulaApiService {
    @GET("sentencas/{formulaId}")
    fun getFormula(@Path("formulaId") formulaId: Int): Call<ResponseBody>
}

object FormulaApi {
    val retrofitService: FormulaApiService by lazy {
        retrofit.create(FormulaApiService::class.java)
    }
}