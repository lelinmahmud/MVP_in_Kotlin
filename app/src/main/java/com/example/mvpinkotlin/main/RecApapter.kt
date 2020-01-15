package com.example.mvpinkotlin.main

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.appcompat.widget.AppCompatTextView
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.mvpinkotlin.R
import com.example.mvpinkotlin.main.RecApapter.RecApapterViewHolder
import com.example.mvpinkotlin.model.CatalogProductsItem
import com.example.mvpinkotlin.session.SharedPrefarenceImpSession
import kotlinx.android.synthetic.main.sample.view.*

class RecApapter(
    private val context: MainActivity,
    private val list: ArrayList<CatalogProductsItem>
,val mainPresenter: MainPresenter) : RecyclerView.Adapter<RecApapterViewHolder>() {

    private  val BASE_URL="http://www.meenaclick.com/back_end/assets/product_images/"
    private val session=SharedPrefarenceImpSession(context)


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecApapterViewHolder {
        val view =
            LayoutInflater.from(context).inflate(R.layout.sample, parent, false)
        return RecApapterViewHolder(view,mainPresenter)
    }

    override fun onBindViewHolder(holder: RecApapterViewHolder, position: Int) {
        val count=0
        Glide.with(context).load(BASE_URL+list.get(position).productImage).into(holder.imageView)
        holder.p_name.text="${list.get(position).productName}"
        holder.price.text="${list.get(position).price}"
        holder.quantity.text="$count"
        checkInCart(list.get(position),holder)
        holder.view.tag= position
        holder.plusBtn.tag=position
        holder.minusBtn.tag=position
        holder.addToCart.tag=position

    }

    fun checkInCart(productsItem: CatalogProductsItem,holder: RecApapterViewHolder){
        val checkList=session.getAllProducts()
        for (i in checkList){
            if (i?.productId ==productsItem.productId){
                holder.addToCart.visibility=View.GONE
                holder.quantity.visibility=View.VISIBLE
                holder.quantity.text="${i?.qty}"
                if (i?.qty ==1){
                    holder.minusBtn.setImageResource(R.drawable.ic_delete)

                }
                holder.minusBtn.visibility=View.VISIBLE

            }
        }
    }

    override fun getItemCount(): Int {
        return list.size
    }

    inner class RecApapterViewHolder(
        iv: View,mainPresenter: MainPresenter
    ) :
        RecyclerView.ViewHolder(iv) {
        var view = iv

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
            var counter=quantity.text.toString().toInt()
            quantity.visibility=View.VISIBLE
            context.tvCartCount.visibility=View.VISIBLE


            if (counter>=1){
                minusBtn.setImageResource(R.drawable.ic_minus_2)
            }




            addToCart.visibility=View.GONE
            minusBtn.visibility=View.VISIBLE
            counter++
            if (counter==1){
                session.addProduct(list.get(positions))
                minusBtn.setImageResource(R.drawable.ic_delete)

                context.tvCartCount.text="${session.getAllProducts()?.size}"
            }
            mainPresenter.updateQty(list.get(positions),counter,context)
            quantity.text="$counter"
            context.tvCartCount.text="${session.getAllProducts()?.size}"
        }


        val decrese=minusBtn.setOnClickListener {
            var positions=minusBtn.tag.toString().toInt()
            var counter=quantity.text.toString().toInt()
            counter--
            if (counter==1){
                minusBtn.setImageResource(R.drawable.ic_delete)
                minusBtn.visibility=View.VISIBLE
                println("counter is : $counter and delete visible is called")

            }

            if (counter==0){

                println("counter is : $counter and remove is called")
                addToCart.visibility=View.VISIBLE
                minusBtn.visibility=View.GONE
                quantity.text="$counter"
                quantity.visibility=View.GONE

                mainPresenter.deleteProduct(list.get(positions),context)

                context.tvCartCount.text="${session.getAllProducts()?.size}"
                if (session.getAllProducts().size==0){
                    context.tvCartCount.visibility=View.GONE
                }

                return@setOnClickListener

            }
            mainPresenter.updateQty(list.get(positions),counter,context)
            quantity.text="$counter"
        }

        val addtoCartBtn=addToCart.setOnClickListener {
            var positions=addToCart.tag.toString().toInt()
            val addValue=1
            session.addProduct(list.get(positions))
            context.tvCartCount.visibility=View.VISIBLE
            context.tvCartCount.text="${session.getAllProducts()?.size}"
            addToCart.visibility=View.GONE
            minusBtn.setImageResource(R.drawable.ic_delete)
            minusBtn.visibility=View.VISIBLE
            quantity.visibility=View.VISIBLE
            quantity.text="$addValue"


        }




    }





}