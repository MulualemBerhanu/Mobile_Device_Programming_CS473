package com.inifiny.walmart

import android.content.Intent
import android.os.Bundle
import android.text.TextUtils
import androidx.appcompat.app.AppCompatActivity
import android.view.View;
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.android.synthetic.main.sign_up.*
import kotlinx.android.synthetic.main.sign_up.email
import kotlinx.android.synthetic.main.sign_up.email_layout
import kotlinx.android.synthetic.main.sign_up.password
import kotlinx.android.synthetic.main.sign_up.password_layout

class SignUp :AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.sign_up)

    }
    fun signUp(view:View){
            if(TextUtils.isEmpty(fname.text)){
                fname_layout.error="please enter first name"
                return;
            }
        if(TextUtils.isEmpty(email.text)){
            email_layout.error="please enter email"
            return;
        }
        if(TextUtils.isEmpty(password.text)){
            password_layout.error="please enter password "
            return;
        }
        var user=User(fname.text.toString(),lname.text.toString(),email.text.toString(),password .text.toString());

        var intent=Intent();
        intent.putExtra("user",user);
        setResult(12,intent);
        finish()

    }
}