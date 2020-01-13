package com.example.mvpinkotlin.shoppingCart

import com.example.mvpinkotlin.model.CatalogProductsItem

interface CartContact {

    interface cartView{
        fun loadCartItem(list:ArrayList<CatalogProductsItem>)
    }


    interface cartPresenter{
        fun getCartItem()
    }
}