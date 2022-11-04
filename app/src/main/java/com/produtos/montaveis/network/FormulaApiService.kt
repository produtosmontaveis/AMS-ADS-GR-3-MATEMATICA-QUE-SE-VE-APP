package com.produtos.montaveis.network

import retrofit2.Retrofit
import retrofit2.converter.scalars.ScalarsConverterFactory
import retrofit2.http.GET
import retrofit2.http.Path

private const val BASE_URL = "https://formulas-api.herokuapp.com"

//private val moshi = Moshi.Builder()
//    .add(KotlinJsonAdapterFactory())
//    .build()

private val retrofit = Retrofit.Builder()
    .addConverterFactory(ScalarsConverterFactory.create())
    .baseUrl(BASE_URL)
    .build()

interface FormulaApiService {
    @GET("sentencas/{formulaId}")
    suspend fun getFormula(@Path("formulaId") formulaId: Int): String
}

object FormulaApi {
    val retrofitService: FormulaApiService by lazy {
        retrofit.create(FormulaApiService::class.java)
    }
}