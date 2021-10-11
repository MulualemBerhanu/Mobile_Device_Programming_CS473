package com.inifiny.walmart

import android.app.ActivityOptions
import android.content.Intent
import android.os.Build
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.RecyclerView
import kotlinx.android.synthetic.main.product_item.view.*

class ProductAdapter(var list:ArrayList<Product>,var activity: AppCompatActivity) : RecyclerView.Adapter<ProductAdapter.ProductHolder>() {
    inner class ProductHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ProductHolder {
        return  ProductHolder(LayoutInflater.from(parent.context).inflate(R.layout.product_item,parent,false));
    }

    override fun onBindViewHolder(holder: ProductHolder, position: Int) {
        var product=list.get(position);
        holder.itemView.apply {
            name.text=product.name;
            color.text=product.color;
            price.text=product.price;
            image.setImageResource(product.image)
            card.setOnClickListener {
                var detail=Intent(context,ProductDetail::class.java)
                detail.putExtra("product",product);
                 if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
                     val options=     ActivityOptions
                        .makeSceneTransitionAnimation(activity, image, "image");
                        context.startActivity(detail,options.toBundle());
                } else {
                    context.startActivity(detail);
                }

            }
        }
    }

    override fun getItemCount(): Int {
        return list.size;
    }
}