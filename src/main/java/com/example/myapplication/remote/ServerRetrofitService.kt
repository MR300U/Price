package com.example.myapplication.remote

import com.example.myapplication.remote.gold.GoldApiService
import com.example.myapplication.remote.time.TimeApiService
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

object ServerRetrofitService {

    private const val url = "https://tools.daneshjooyar.com/api/v1/"

    private val retrofit = Retrofit.Builder()
        .baseUrl(url)
        .addConverterFactory(GsonConverterFactory.create())
        .build()

    val apiService : TimeApiService = retrofit.create(TimeApiService::class.java)

    val GoldsApiService : GoldApiService = retrofit.create(GoldApiService::class.java)
}