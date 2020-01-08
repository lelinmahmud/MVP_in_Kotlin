package com.example.mvpinkotlin.main

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import android.widget.Toast
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.mvpinkotlin.R
import com.example.mvpinkotlin.main.RecApapter.RecApapterViewHolder
import com.example.mvpinkotlin.model.CatalogProductsItem
import es.dmoral.toasty.Toasty
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
        holder.view.tag= position

    }

    override fun getItemCount(): Int {
        return list.size
    }

    inner class RecApapterViewHolder(iv: View) :
        RecyclerView.ViewHolder(iv) {
        var view = iv

        val imageView=iv.offerProductPicId
        val p_name=iv.offerProductId

        val itemView=view.setOnClickListener {
            var position=view.tag.toString().toInt()

            Toasty.success(context,"${list.get(position).productName}",Toast.LENGTH_SHORT).show()
            println(position)
        }


    }

}