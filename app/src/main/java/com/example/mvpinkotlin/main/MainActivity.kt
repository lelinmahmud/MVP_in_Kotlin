package com.example.mvpinkotlin.main

import android.app.Activity
import android.content.Context
import android.graphics.Color
import android.os.Bundle
import android.util.Log
import android.view.Menu
import android.view.MenuItem
import android.view.View
import android.view.inputmethod.InputMethodManager
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.StaggeredGridLayoutManager
import com.example.mvpinkotlin.R
import com.example.mvpinkotlin.model.CatalogProductsItem
import com.example.mvpinkotlin.utils.GridSpacingItemDecoration
import com.example.mvpinkotlin.utils.ScreenUtils
import com.miguelcatalan.materialsearchview.MaterialSearchView
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
        initToolbar()

        rec2.layoutManager=StaggeredGridLayoutManager(2, StaggeredGridLayoutManager.VERTICAL)
        rec2.addItemDecoration(GridSpacingItemDecoration(2,5,true))
        val adapter2=ShimmerAdapter(this)
        rec2.adapter=adapter2

        search_view.setOnQueryTextListener(object :MaterialSearchView.OnQueryTextListener{
            override fun onQueryTextSubmit(query: String?): Boolean {
                Log.d("searchview","onQueryTextSubmit")

                hideKeyborad()

                return true
            }

            override fun onQueryTextChange(newText: String?): Boolean {
                Log.d("searchview","onQueryTextChange")
                return true
            }

        })


        search_view.setOnSearchViewListener(object :MaterialSearchView.SearchViewListener{
            override fun onSearchViewClosed() {

                Log.d("searchview","onSearchViewClosed")
            }

            override fun onSearchViewShown() {
                Log.d("searchview","onSearchViewShown")

            }

        })





    }



    override fun setUpRecData(list: ArrayList<CatalogProductsItem>) {
        var i=13.0

        val apapter=RecApapter(this,list)
        rec.layoutManager=StaggeredGridLayoutManager(2, StaggeredGridLayoutManager.VERTICAL)
     //   rec.addItemDecoration(DividerItemDecoration(this,GridLayoutManager.HORIZONTAL))
        rec.addItemDecoration(GridSpacingItemDecoration(2, ScreenUtils.dp2px(this,i.toFloat()), true))
      //  shmmier.stopShimmer();
        rec2.visibility=View.GONE
        rec.adapter=apapter
     //   shmmier.visibility=View.GONE
        rec.visibility=View.VISIBLE

    }


    fun initToolbar(){
        toolbar.setTitle("Cereals")
        toolbar.setNavigationIcon(R.drawable.ic_arrow_back)
        toolbar.setTitleTextColor(Color.WHITE)
        setSupportActionBar(toolbar)
    }



    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.menu_item,menu)

        val item: MenuItem = menu!!.findItem(R.id.menu_item_search)
        search_view.setMenuItem(item)

        return true
    }


    override fun onBackPressed() {
        if (search_view.isSearchOpen()) {
            search_view.closeSearch();
        } else {
            super.onBackPressed();
        }

    }

    fun hideKeyborad(){
        val inputManager:InputMethodManager = getSystemService(Context.INPUT_METHOD_SERVICE) as InputMethodManager
        inputManager.hideSoftInputFromWindow(currentFocus!!.windowToken, InputMethodManager.SHOW_FORCED)
    }
}
