package com.example.walmartlogin

import android.content.Intent
import android.os.Bundle
import android.text.TextUtils
import androidx.appcompat.app.AppCompatActivity
import android.view.View;
import kotlinx.android.synthetic.main.activity_create_acount.*
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.android.synthetic.main.activity_main.email
import kotlinx.android.synthetic.main.activity_main.password
import kotlinx.android.synthetic.main.activity_create_acount.*


class CreateAcount : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_create_acount)
    }

    fun signUp(view:View){
        if(TextUtils.isEmpty(fname.text)){
            fname.hint="please enter first name"

            return;
        }
        if(TextUtils.isEmpty(email.text)){
            email.hint="please enter email"
            return;
        }
        if(TextUtils.isEmpty(password.text)){
            password.hint="please enter password "
            return;
        }
        var user=User(fname.text.toString(),lname.text.toString(),email.text.toString(),password .text.toString());

        var intent=Intent();
        intent.putExtra("user",user);
        setResult(12,intent);
        finish()

    }
}