package com.example.myapplication.remote.time


import com.example.myapplication.remote.dataModel.TimeModel
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Query

interface TimeApiService {

    @GET("date/now")
    fun getTime(
        @Query("short") short: Boolean
    ):Call<TimeModel>

}