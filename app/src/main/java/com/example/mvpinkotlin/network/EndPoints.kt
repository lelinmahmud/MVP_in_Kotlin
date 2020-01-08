package com.example.mvpinkotlin.network

import com.example.mvpinkotlin.model.Response
import retrofit2.Call
import retrofit2.http.GET

interface EndPoints {

    @GET("catalog-contents/1/cereals?page=1")
    fun getProduct():Call<Response>
}