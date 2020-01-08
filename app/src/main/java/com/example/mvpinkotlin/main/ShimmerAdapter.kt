package com.example.mvpinkotlin.main

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.mvpinkotlin.R
import kotlinx.android.synthetic.main.shimmer_demo_2.view.*

class ShimmerAdapter(val context:Context): RecyclerView.Adapter<ShimmerAdapter.ViewHolder>() {


    class ViewHolder(view:View):RecyclerView.ViewHolder(view) {
        val shimmer2=view.shimmer2
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view=LayoutInflater.from(context).inflate(R.layout.shimmer_demo_2,parent,false)
        return ViewHolder(view)
    }

    override fun getItemCount(): Int {
        return 6
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.shimmer2.startShimmer()
    }
}