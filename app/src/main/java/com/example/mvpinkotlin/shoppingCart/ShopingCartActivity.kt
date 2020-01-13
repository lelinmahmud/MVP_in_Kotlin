package com.example.mvpinkotlin.shoppingCart

import android.graphics.Color
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.MenuItem
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.mvpinkotlin.R
import com.example.mvpinkotlin.model.CatalogProductsItem
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.android.synthetic.main.activity_shoping_cart.*
import kotlinx.android.synthetic.main.app_bar_primary.*
import kotlinx.android.synthetic.main.app_bar_primary.toolbar

class ShopingCartActivity : AppCompatActivity(),CartContact.cartView{

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_shoping_cart)
        initToolBar()
        rv_cart.setHasFixedSize(true)
        rv_cart.layoutManager=LinearLayoutManager(this)
        val adapter=CartAdapter(this)
        rv_cart.adapter=adapter

    }

    override fun loadCartItem(list: ArrayList<CatalogProductsItem>) {

    }


    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        if (item.itemId==android.R.id.home){
            onBackPressed()
        }
        return super.onOptionsItemSelected(item)
    }

    fun initToolBar(){
        toolbar.setTitle("Shoping Cart (4)")
        toolbar.setNavigationIcon(R.drawable.ic_arrow_back)
        toolbar.setTitleTextColor(Color.WHITE)
        setSupportActionBar(toolbar)
    }


}
