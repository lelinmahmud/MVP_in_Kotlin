package com.example.mvpinkotlin.shoppingCart

import android.content.Context
import com.example.mvpinkotlin.main.MainActivity
import com.example.mvpinkotlin.model.CatalogProductsItem
import com.example.mvpinkotlin.session.SharedPrefarenceImpSession

class CartPresenter(internal val view:CartContact.cartView) :CartContact.cartPresenter {


    override fun getCartItem(context: Context) {
        val session=SharedPrefarenceImpSession(context)
        val list=session.getAllProducts()
        view.initToolBar()
        if (list.size==0){
            view.emptyCart()

            return
        }
        view.initToolBar()


        view.loadCartItem(list)
    }

    override fun getCartItemPrice(context: Context) {

        val session=SharedPrefarenceImpSession(context)
        val list=session.getAllProducts()
        view.initToolBar()

        if (list.size==0){
            view.emptyCart()
            return
        }

        var counter=0;
        for (i in list){
            counter+= i?.price!!
        }

        view.totalPrice(counter)
    }

    fun removeProducts(productsItem: CatalogProductsItem,context: Context){
        val session=SharedPrefarenceImpSession(context)
        session.removeProduct(productsItem)
        val list=session.getAllProducts()
        view.initToolBar()
        if (list.size==0){
            view.emptyCart()
            return
        }
        view.loadCartItem(list)
        var counter=0;
        for (i in list){
            counter+= i?.price!!* i.qty!!
        }

        view.totalPrice(counter)


    }

    fun updateQty(index:Int,qty:Int,context: Context){
        val session=SharedPrefarenceImpSession(context)
        session.addQty(index,qty)
        val list=session.getAllProducts()
        view.initToolBar()

        if (list.size==0){
            view.emptyCart()
            return
        }
        view.loadCartItem(list)
        var counter=0;
        for (i in list){
            counter+= i?.price!!* i.qty!!
        }

        view.totalPrice(counter)
    }


}