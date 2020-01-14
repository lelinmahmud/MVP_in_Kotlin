package com.example.mvpinkotlin.shoppingCart

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.mvpinkotlin.R
import com.example.mvpinkotlin.model.CatalogProductsItem
import kotlinx.android.synthetic.main.cart_item.view.*
import kotlinx.android.synthetic.main.sample.view.*

class CartAdapter(
    val list: ArrayList<CatalogProductsItem?>,
    val context: Context,val cartPresenter: CartPresenter) :
    RecyclerView.Adapter<CartAdapter.ViewHoler>() {


    private  val BASE_URL="http://www.meenaclick.com/back_end/assets/product_images/"

    class ViewHoler(view:View,cartPresenter: CartPresenter,context: Context):RecyclerView.ViewHolder(view) {

//        var counter=1
        val imageView=view.iv_image_cart
        val p_name=view.tv_name
        val price=view.tv_price
        val weigth=view.tv_weight
        val delete=view.iv_delete
        val plus=view.iv_plus
        val minus=view.iv_minus
        val qunatity_tv=view.tv_cart_count

        val increment=plus.setOnClickListener {
            var position=plus.tag.toString().toInt()
            var counter=qunatity_tv.text.toString().toInt()
            counter++
            qunatity_tv.text="$counter"
            cartPresenter.updateQty(position,counter,context)


        }
        val decrement=minus.setOnClickListener {
            var position=minus.tag.toString().toInt()
            var counter=qunatity_tv.text.toString().toInt()

            if (counter==1){
                return@setOnClickListener
            }
            counter--
            qunatity_tv.text="$counter"
            qunatity_tv.text="$counter"
            cartPresenter.updateQty(position,counter,context)
        }


    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHoler {
        val view=LayoutInflater.from(context).inflate(R.layout.cart_item,parent,false)
        return ViewHoler(view,cartPresenter,context)
    }

    override fun getItemCount(): Int {
        return list.size
    }

    override fun onBindViewHolder(holder: ViewHoler, position: Int) {
        Glide.with(context).load(BASE_URL+ list.get(position)!!.productImage).into(holder.imageView)
        holder.p_name.text="${list.get(position)?.productName}"
        holder.price.text="${list.get(position)?.price}"
        holder.weigth.text="${list.get(position)!!.weight} EA"
        holder.qunatity_tv.text="${list.get(position)!!.qty}"
        holder.plus.tag=position
        holder.minus.tag=position
        holder.delete.setOnClickListener {
            cartPresenter.removeProducts(list.get(position)!!,context)
            list.remove(list.get(position))
            notifyDataSetChanged()
        }

    }
}