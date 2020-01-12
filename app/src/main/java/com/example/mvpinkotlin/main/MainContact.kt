package com.example.mvpinkotlin.main

import com.example.mvpinkotlin.model.CatalogProductsItem
import com.example.mvpinkotlin.model.Response
import java.net.SecureCacheResponse

interface MainContact {

    interface view {
        fun setUpRecData(list:ArrayList<CatalogProductsItem>)
        fun cartItemUpdate(itemCount:Int)

    }

    interface presenter{
        fun data()
        fun cartItemClicked()
    }

}