package com.example.walmartlogin

import android.app.Activity
import android.content.Intent
import android.net.Uri
import android.os.Bundle
import android.text.TextUtils
import android.util.Log
import android.view.View
import androidx.activity.result.ActivityResult
import androidx.activity.result.ActivityResultLauncher

import androidx.activity.result.contract.ActivityResultContracts.StartActivityForResult
import androidx.appcompat.app.AppCompatActivity
import kotlinx.android.synthetic.main.activity_main.*
import kotlin.collections.forEach as forEach1


class MainActivity : AppCompatActivity() {
    var users= arrayListOf<User>(
        User("Mulualem","Berhanu","Mule2069@gmail.com","12345"),
        User("Mulualem","Adisu","BerhanuMuluakem@gmail.com","12345"),
    )

    var startForResult:ActivityResultLauncher<Intent>?=null;
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main);


        startForResult = registerForActivityResult(StartActivityForResult()) { result: ActivityResult ->
            if (result.resultCode == 12) {
                val intent = result.data
                var user:User?= intent?.getSerializableExtra("user") as User;
                user?.let { users.add(it) }
                Log.i("user", user?.toString().toString());

                // Handle the Intent
            }
        }
    }
    fun signin(view:View) {
        if (TextUtils.isEmpty(email.text)) {
            email.hint = "please enter your email"
            return;
        }

        if (TextUtils.isEmpty(password.text)) {
            password.hint = "please enter your password"
            return;

        }
        var user = user(email.text.toString());
        if (user == null) {
            email.hint = "User is not found"
            return
        }
        if (user.password.equals(password.text.toString()))
        {
            var intent=Intent(this,CategoryActivity::class.java);
            intent.putExtra("user",user);
            startActivity(intent);

        }
        else password.hint="password is not correct"
    }


    fun  user (email:String): User? {
        users.forEach { if(it.email.equals(email) ) {
            return it
        }
        }
        return  null;
    }
    fun createAccount(view:View){
        val intent = Intent(this,CreateAcount::class.java);

        startForResult?.launch(intent)
    }
    fun forgetPassword(view:View){
        if(TextUtils.isEmpty(email.text)){
            email.hint="please enter your email address"
        }
        var user = user(email.text.toString());
        user?.let {
            var intent=Intent(Intent.ACTION_SEND);
            intent.putExtra(Intent.EXTRA_EMAIL, user.email);
            intent.putExtra(Intent.EXTRA_SUBJECT, "Password recovery");
            intent.putExtra(Intent.EXTRA_TEXT, "Your password for Walmart login is ${user.password}");
            startActivity(intent)

        }?:let { email.hint="User is not found" }
    }


}

