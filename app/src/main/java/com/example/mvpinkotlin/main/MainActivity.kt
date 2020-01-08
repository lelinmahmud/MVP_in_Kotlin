package com.example.mvpinkotlin.main

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.DividerItemDecoration
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.mvpinkotlin.R
import com.example.mvpinkotlin.model.CatalogProductsItem
import com.example.mvpinkotlin.model.Response
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity(),
    MainContact.view {

    lateinit var presenter: MainPresenter
    lateinit var list:ArrayList<CatalogProductsItem>
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        presenter= MainPresenter(this)
        list= ArrayList()

        presenter.data()

        println("hello")



    }



    override fun setUpRecData(list: ArrayList<CatalogProductsItem>) {

        val apapter=RecApapter(this,list)
        rec.layoutManager=GridLayoutManager(this,2)
        rec.addItemDecoration(DividerItemDecoration(this,GridLayoutManager.HORIZONTAL))
        rec.adapter=apapter

    }
}
