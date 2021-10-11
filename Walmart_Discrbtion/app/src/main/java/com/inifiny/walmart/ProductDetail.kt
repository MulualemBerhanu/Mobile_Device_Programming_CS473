package com.inifiny.walmart

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import kotlinx.android.synthetic.main.product_detail.*
import kotlinx.android.synthetic.main.product_detail.image

class ProductDetail:AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.product_detail);
        if (intent!=null){
            var product:Product= intent.getSerializableExtra("product") as Product;
            product?.let {
                setTitle(product.name)

                image.setImageResource(product.image);
                color.text=product.color
                price.text=product.price;
                descrption.text=product.description;

            }


        }
    }
}