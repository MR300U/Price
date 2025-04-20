package com.example.myapplication.remote.gold

import com.example.myapplication.remote.dataModel.GoldModel
import retrofit2.Call
import retrofit2.http.GET

interface GoldApiService {

    @GET("currencies")
    fun getGold(
    ):Call<GoldModel>

}