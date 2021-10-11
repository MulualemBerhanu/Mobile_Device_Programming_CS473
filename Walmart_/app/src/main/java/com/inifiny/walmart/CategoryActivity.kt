package com.inifiny.walmart

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.RecyclerView
import kotlinx.android.synthetic.main.category_item.view.*
import kotlinx.android.synthetic.main.category_layout.*

class CategoryActivity:AppCompatActivity()  {
    var recyclerView:RecyclerView?=null;
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.category_layout);
        recyclerView=findViewById(R.id.recyclerView);
        recyclerView?.layoutManager=GridLayoutManager(this,2);
        recyclerView?.adapter=CategoryAdapter();
        var user:User?= intent.getSerializableExtra("user") as User?;
        name.text = "Welcome ${user?.firstName}";
        email.text="${user?.email}";
    }
   inner class  CategoryAdapter (): RecyclerView.Adapter<CategoryAdapter.CategoryHolder>() {
       var titles= arrayOf("Electronics","Clothing","Beauty","Food");
        var images= arrayOf(R.drawable.electronics,R.drawable.clothing,R.drawable.beauty,R.drawable.food);

       inner  class CategoryHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {

       }


       override fun onBindViewHolder(holder: CategoryHolder, position: Int) {
           holder.itemView.title.text=titles[position];
           holder.itemView.image.setImageResource(images[position])
           holder.itemView.card.setOnClickListener {
               Toast.makeText(holder.itemView.context,"You have chosen the Clothing category of  ${titles[position]}",Toast.LENGTH_SHORT).show()
                if(titles[position].equals("Electronics"))
                {
                    var dialog=CategoryDetail();
                    dialog.show(supportFragmentManager,null);
                }
           }

       }

       override fun getItemCount(): Int {
        return  titles.size
       }
       override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CategoryHolder {
           return  CategoryHolder(LayoutInflater.from(parent.context).inflate(R.layout.category_item,parent,false))
       }

   }

}