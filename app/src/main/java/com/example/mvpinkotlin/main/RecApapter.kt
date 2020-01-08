package com.example.mvpinkotlin.main

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.mvpinkotlin.R
import com.example.mvpinkotlin.main.RecApapter.RecApapterViewHolder
import com.example.mvpinkotlin.model.CatalogProductsItem
import kotlinx.android.synthetic.main.sample.view.*

class RecApapter(
    private val context: Context,
    private val list: ArrayList<CatalogProductsItem>
) : RecyclerView.Adapter<RecApapterViewHolder>() {

    private  val BASE_URL="http://www.meenaclick.com/back_end/assets/product_images/"


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecApapterViewHolder {
        val view =
            LayoutInflater.from(context).inflate(R.layout.sample, parent, false)
        return RecApapterViewHolder(view)
    }

    override fun onBindViewHolder(holder: RecApapterViewHolder, position: Int) {
        Glide.with(context).load(BASE_URL+list.get(position).productImage).into(holder.imageView)
        holder.p_name.text="${list.get(position).productName}"
    }

    override fun getItemCount(): Int {
        return list.size
    }

    inner class RecApapterViewHolder(itemView: View) :
        RecyclerView.ViewHolder(itemView) {
        val imageView=itemView.offerProductPicId
        val p_name=itemView.offerProductId

    }

}