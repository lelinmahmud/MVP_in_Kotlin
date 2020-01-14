package com.example.mvpinkotlin.shoppingCart

import android.graphics.Color
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.MenuItem
import android.view.View
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.mvpinkotlin.R
import com.example.mvpinkotlin.main.MainActivity
import com.example.mvpinkotlin.model.CatalogProductsItem
import com.example.mvpinkotlin.session.SharedPrefarenceImpSession
import kotlinx.android.synthetic.main.activity_shoping_cart.*
import kotlinx.android.synthetic.main.app_bar_primary.toolbar

class ShopingCartActivity : AppCompatActivity(),CartContact.cartView{

    lateinit var presenter: CartPresenter
    lateinit var session: SharedPrefarenceImpSession

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_shoping_cart)
        session= SharedPrefarenceImpSession(this)
        presenter= CartPresenter(this)
        presenter.getCartItem(this)
        presenter.getCartItemPrice(this)


    }

    override fun loadCartItem(list: ArrayList<CatalogProductsItem?>) {
        rv_cart.setHasFixedSize(true)
        rv_cart.layoutManager=LinearLayoutManager(this)
        val adapter=CartAdapter(list,this,presenter)
        rv_cart.adapter=adapter
    }

    override fun totalPrice(price: Int) {
        cart_price_total.text="৳$price BDT"
        sub_total_value_cart.text="৳$price"
        toolbar.setTitle("Shoping Cart (${session.getAllProducts().size})")
    }

    override fun emptyCart() {
        rv_cart.visibility=View.GONE
        ll_bottom.visibility=View.GONE
        empty_cart.visibility=View.VISIBLE


    }


    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        if (item.itemId==android.R.id.home){
            onBackPressed()
        }
        return super.onOptionsItemSelected(item)
    }

    override fun initToolBar(){
        toolbar.setNavigationIcon(R.drawable.ic_arrow_back)
        toolbar.setTitleTextColor(Color.WHITE)
        toolbar.setTitle("Shoping Cart (${session.getAllProducts().size})")
        setSupportActionBar(toolbar)
    }


}
