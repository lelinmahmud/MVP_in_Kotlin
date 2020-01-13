package com.example.mvpinkotlin.shoppingCart

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.mvpinkotlin.R
import com.example.mvpinkotlin.model.CatalogProductsItem

class CartAdapter(val context: Context) :
    RecyclerView.Adapter<CartAdapter.ViewHoler>() {



    class ViewHoler(view:View):RecyclerView.ViewHolder(view) {

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHoler {
        val view=LayoutInflater.from(context).inflate(R.layout.cart_item,parent,false)
        return ViewHoler(view)
    }

    override fun getItemCount(): Int {
        return 2
    }

    override fun onBindViewHolder(holder: ViewHoler, position: Int) {

    }
}