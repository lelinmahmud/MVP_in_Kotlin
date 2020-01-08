package com.example.mvpinkotlin.network

import com.example.mvpinkotlin.model.Response
import retrofit2.Call

class Repisitory {

    companion object{
         fun getProducts():Call<Response>{
            val endPoints=ApiClient.instance.getProduct()
            return endPoints

        }


 }
}