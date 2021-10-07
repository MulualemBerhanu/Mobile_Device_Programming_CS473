package com.inifiny.quizeapp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View;
import android.widget.CheckBox
import android.widget.RadioGroup
import android.widget.Toast
import androidx.appcompat.app.AlertDialog
import java.text.SimpleDateFormat
import java.util.*

class MainActivity : AppCompatActivity() {
    lateinit var radioGroup: RadioGroup;
    lateinit var checkBox1: CheckBox;
    lateinit var checkBox2: CheckBox;
    lateinit var checkBox3: CheckBox;
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        radioGroup=findViewById(R.id.radiogroup);
        checkBox1=findViewById(R.id.answer1);
        checkBox2=findViewById(R.id.answer2);
        checkBox3=findViewById(R.id.answer3);
    }
    fun submit(view:View){
        var total=0;
        val  answer=radioGroup.checkedRadioButtonId;
        total=total.plus(if (answer==R.id.ans) 50 else 0);
        Log.i("answer","${answer}")
        total=total.plus(if (checkBox1.isChecked&&checkBox2.isChecked&&checkBox3.isChecked) 50 else 0);
        var builder=AlertDialog.Builder(this);
        builder.setTitle("Congratulation")
        var format=SimpleDateFormat("hh:mm: a");
        builder.setMessage("You summited ${format.format(Date())} and achieved ${total} %")
        builder.show();
    }

    fun  reset(view:View){
        checkBox1.setChecked(false);
        checkBox2.setChecked(false);
        checkBox3.setChecked(false);
        radioGroup.clearCheck();
    }
}