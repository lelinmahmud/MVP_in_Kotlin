package com.example.mvpinkotlin.main

import android.content.Context
import com.example.mvpinkotlin.model.CatalogProductsItem
import com.example.mvpinkotlin.model.Response
import com.example.mvpinkotlin.network.Repisitory
import com.example.mvpinkotlin.session.SharedPrefarenceImpSession
import retrofit2.Call
import retrofit2.Callback

@Suppress("UNCHECKED_CAST")
class MainPresenter(internal val view: MainContact.view): MainContact.presenter {

    lateinit var session: SharedPrefarenceImpSession


    override fun data() {
        Repisitory.getProducts()
            .enqueue(object :Callback<Response>{
                override fun onFailure(call: Call<Response>, t: Throwable) {
                    println(t.message)
                }

                override fun onResponse(
                    call: Call<Response>,
                    response: retrofit2.Response<Response>
                ) {
                    if (response.body()?.status!!){
                        view.setUpRecData(response.body()?.catalogProducts as ArrayList<CatalogProductsItem>)
                    }
                }

            })
    }

    override fun cartItemClicked() {
        view.cartItemUpdate(5)
    }

    override fun cartButtonClicked() {

        view.navigateToActivity()

    }


    fun updateCart(){
        session.getAllProducts()?.size?.let { view.cartItemUpdate(it) }
    }


    fun updateQty(productsItem: CatalogProductsItem,qty:Int,context: Context){
        val session=SharedPrefarenceImpSession(context)
        session.addProductWithQunatity(productsItem,qty)

    }

    fun deleteProduct(item: CatalogProductsItem,context: Context){
        var sessio=SharedPrefarenceImpSession(context)
        sessio.remove(item)
    }


}