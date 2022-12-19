package com.example.crytpcurrencytracker

import retrofit2.Call
import retrofit2.http.GET

interface MyAPICall {

    @get:GET("v1/cryptocurrency/listings/latest?CMC_PRO_API_KEY=959ac1f4-e1d6-4d87-8472-8c231e78527c")
    val call : Call<DataModel>

}