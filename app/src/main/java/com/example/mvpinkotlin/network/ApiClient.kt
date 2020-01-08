package com.example.mvpinkotlin.network

import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

object ApiClient {

    private const val BASE_URL="http://www.meenaclick.com/api/"

    val instance:EndPoints by lazy {
        val retrofit=Retrofit.Builder()
            .baseUrl(BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .build()

        retrofit.create(EndPoints::class.java)
    }




}