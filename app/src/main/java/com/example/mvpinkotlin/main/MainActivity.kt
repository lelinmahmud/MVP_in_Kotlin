package com.example.mvpinkotlin.main

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import androidx.recyclerview.widget.*
import com.example.mvpinkotlin.R
import com.example.mvpinkotlin.model.CatalogProductsItem
import com.example.mvpinkotlin.model.Response
import com.example.mvpinkotlin.utils.GridItemDecoration
import com.example.mvpinkotlin.utils.GridSpacingItemDecoration
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
        //shmmier.startShimmer()

        presenter.data()

        rec2.layoutManager=StaggeredGridLayoutManager(2, StaggeredGridLayoutManager.VERTICAL)
        rec2.addItemDecoration(GridSpacingItemDecoration(2,5,true))
        val adapter2=ShimmerAdapter(this)
        rec2.adapter=adapter2





    }



    override fun setUpRecData(list: ArrayList<CatalogProductsItem>) {

        val apapter=RecApapter(this,list)
        rec.layoutManager=StaggeredGridLayoutManager(2, StaggeredGridLayoutManager.VERTICAL)
     //   rec.addItemDecoration(DividerItemDecoration(this,GridLayoutManager.HORIZONTAL))
        rec.addItemDecoration(GridSpacingItemDecoration(2,5,true))
      //  rec.addItemDecoration(GridItemDecoration(10,2))
      //  shmmier.stopShimmer();
        rec2.visibility=View.GONE
        rec.adapter=apapter
     //   shmmier.visibility=View.GONE
        rec.visibility=View.VISIBLE

    }
}
