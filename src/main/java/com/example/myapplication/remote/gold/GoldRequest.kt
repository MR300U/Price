package com.example.myapplication.remote.gold

import com.example.myapplication.remote.dataModel.GoldModel


interface GoldRequest {

    fun onSuccess(data : GoldModel)

    fun onNotSuccess(message : String)

    fun onError(error: String)

}