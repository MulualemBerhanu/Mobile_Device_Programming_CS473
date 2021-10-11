package com.inifiny.walmart

import android.content.ActivityNotFoundException
import android.content.Intent
import android.os.Bundle
import android.text.TextUtils
import android.util.Log
import android.view.View
import android.widget.Toast
import androidx.activity.result.ActivityResult
import androidx.activity.result.ActivityResultLauncher
import androidx.activity.result.contract.ActivityResultContracts.StartActivityForResult
import androidx.appcompat.app.AppCompatActivity
import kotlinx.android.synthetic.main.activity_main.*


class MainActivity : AppCompatActivity() {
    var users= arrayListOf<User>(
        User("Mulualem","Berhanu","mule@gmail.com","12345"),
        User("Adisu","berhanu","adika@gmail.com","12345"),
        User("Tsi","Adisu","tsi@gmail.com","12345"),
        User("seid","abrar","seya@gmail.com","12345"),
        User("endi","endagnegnew","endi@gmail.com","1234567")
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
    fun signIn(view:View) {
        if (TextUtils.isEmpty(email.text)) {
            email_layout.error = "please enter your email"
            return;
        }

        if (TextUtils.isEmpty(password.text)) {
            password_layout.error = "please enter your password"
            return;

        }
        var user = user(email.text.toString());
        if (user == null) {
            email_layout.error = "User is not found"
            return
        }
        if (user.password.equals(password.text.toString()))
        {
            var intent=Intent(this,CategoryActivity::class.java);
            intent.putExtra("user",user);
            startActivity(intent);

        }
        else password_layout.error="password is not correct"
    }

    fun  user (email:String): User? {
        users.forEach { if(it.email.equals(email) )return it; }
        return  null;
    }
    fun createAccount(view:View){
        val intent = Intent(this,SignUp::class.java);

       startForResult?.launch(intent)
    }
    fun forgetPassword(view:View){
        if(TextUtils.isEmpty(email.text)){
            email_layout.error="please enter your email address"
        }
        var user = user(email.text.toString());
        user?.let {
            var intent=Intent(Intent.ACTION_SEND);
            intent.putExtra(Intent.EXTRA_EMAIL, user.email);
            intent.putExtra(Intent.EXTRA_SUBJECT, "Password recovery");
            intent.putExtra(Intent.EXTRA_TEXT, "Your password for Walmart login is ${user.password}");

            intent.setType("message/rfc822")

            try {
                startActivity(
                    Intent.createChooser(
                        intent,
                        "Send email using..."
                    )
                )
            } catch (ex: ActivityNotFoundException) {
                Toast.makeText(
                    this,
                    "No email clients installed.",
                    Toast.LENGTH_SHORT
                ).show()
            }


        }?:let { email_layout.error="User is not found" }
    }


    }

