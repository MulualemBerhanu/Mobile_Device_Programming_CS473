package com.example.dinnerdecider

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Toast

import kotlinx.android.synthetic.main.activity_main.*
import kotlin.random.Random

class MainActivity : AppCompatActivity() {
    var foods= arrayListOf("Hamburger", "Pizza", "Mexican", " American", "Chinese")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        
    }
    fun addfood(view : View){
        val textstring=editTextTextPersonName.text.toString()
        val newfood=if (textstring.isEmpty())null else textstring;
        newfood?.let { foods.add(newfood); tv.text=newfood }
            ?:let { Toast.makeText(this,"Please enter food name",Toast.LENGTH_SHORT).show() };

    }
    fun decide(view:View){
        tv.text=foods.get(Random.nextInt(0,foods.size))

    }
}