package com.example.myapplication.remote.time

import com.example.myapplication.remote.dataModel.TimeModel


interface TimeRequest {

    fun onSuccess(data : TimeModel)

    fun onNotSuccess(message : String)

    fun onError(error: String)

}