package com.example.mvpinkotlin.shoppingCart

import android.content.Context
import com.example.mvpinkotlin.main.MainActivity
import com.example.mvpinkotlin.model.CatalogProductsItem

interface CartContact {

    interface cartView{
        fun loadCartItem(list: ArrayList<CatalogProductsItem?>)
        fun totalPrice(price:Int)
        fun emptyCart()
        fun initToolBar()
    }


    interface cartPresenter{
        fun getCartItem(context: Context)
        fun getCartItemPrice(context: Context)
    }
}