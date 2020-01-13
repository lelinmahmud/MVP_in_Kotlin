package com.example.mvpinkotlin.main

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.mvpinkotlin.R
import com.example.mvpinkotlin.main.RecApapter.RecApapterViewHolder
import com.example.mvpinkotlin.model.CatalogProductsItem
import com.example.mvpinkotlin.session.SharedPrefarenceImpSession
import es.dmoral.toasty.Toasty
import kotlinx.android.synthetic.main.sample.view.*

class RecApapter(
    private val context: MainActivity,
    private val list: ArrayList<CatalogProductsItem>
) : RecyclerView.Adapter<RecApapterViewHolder>() {

    private  val BASE_URL="http://www.meenaclick.com/back_end/assets/product_images/"
    private val session=SharedPrefarenceImpSession(context)


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecApapterViewHolder {
        val view =
            LayoutInflater.from(context).inflate(R.layout.sample, parent, false)
        return RecApapterViewHolder(view)
    }

    override fun onBindViewHolder(holder: RecApapterViewHolder, position: Int) {
        Glide.with(context).load(BASE_URL+list.get(position).productImage).into(holder.imageView)
        holder.p_name.text="${list.get(position).productName}"
        holder.price.text="${list.get(position).price}"
        holder.view.tag= position
        holder.plusBtn.tag=position
        holder.minusBtn.tag=position
        holder.addToCart.tag=position

    }

    override fun getItemCount(): Int {
        return list.size
    }

    inner class RecApapterViewHolder(iv: View) :
        RecyclerView.ViewHolder(iv) {
        var view = iv
        var count=0;

        val imageView=iv.offerProductPicId
        val p_name=iv.offerProductId
        val quantity=iv.tv_in_cart_quantity
        val plusBtn=iv.btn_increse
        val minusBtn=iv.btn_decrese
        val addToCart=iv.add_to_cart_tv
        val price=iv.current_price_tv


        val itemView=view.setOnClickListener {
            var position=view.tag.toString().toInt()

//            Toasty.success(context,"${list.get(position).productName}",Toast.LENGTH_SHORT).show()
            println(position)
        }
        val increse=plusBtn.setOnClickListener {
            var positions=plusBtn.tag.toString().toInt()
            if (count>=0){
                minusBtn.setImageResource(R.drawable.ic_minus_2)
            }

            addToCart.visibility=View.GONE
            minusBtn.visibility=View.VISIBLE
            count++
            quantity.setText(""+count)
            context.tvCartCount.text="${session.getAllProducts()?.size}"
        }


        val decrese=minusBtn.setOnClickListener {
            var positions=minusBtn.tag.toString().toInt()

            if (count==2){
                minusBtn.setImageResource(R.drawable.ic_delete)
                minusBtn.visibility=View.VISIBLE
            }

            if (count==1){
                addToCart.visibility=View.VISIBLE
                minusBtn.visibility=View.GONE
                quantity.setText("")
                session.removeProduct(list.get(positions))
                context.tvCartCount.text="${session.getAllProducts()?.size}"

                count=0
                return@setOnClickListener

            }

            count--
            quantity.setText(""+count)
        }

        val addtoCartBtn=addToCart.setOnClickListener {
            var positions=addToCart.tag.toString().toInt()
            session.addProduct(list.get(positions))
            context.tvCartCount.text="${session.getAllProducts()?.size}"
            addToCart.visibility=View.GONE
            minusBtn.visibility=View.VISIBLE
            quantity.setText(""+count)


        }




    }

}