package com.example.tablelayout

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Gravity
import android.view.View
import android.widget.TableLayout
import android.widget.TableRow
import android.widget.TextView
import android.widget.Toast

import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {
    var table:TableLayout?=null;
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
    }

    fun addNewTableRow(view:View){
        if (vcode.text.isNotEmpty()&& vname.text.isNotEmpty())
            let {
                var row=TableRow(this);
                var rcode=TextView(this);
                val rname=TextView(this);
                rcode.text=vcode.text;
                rname.text=vname.text;
                row.addView(rcode);
                row.addView(rname);
                rcode.gravity=Gravity.CENTER;
                rname.gravity=Gravity.CENTER;
                val padding=5;
                rcode.setPadding(padding,padding,padding,padding);
                rname.setPadding(padding,padding,padding,padding);

                table?.addView(row);
            }else Toast.makeText(this,"Please enter name or code in input filed",Toast.LENGTH_SHORT).show();
    }

}