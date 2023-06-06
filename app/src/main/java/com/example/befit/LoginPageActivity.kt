package com.example.befit

import android.annotation.SuppressLint
import android.content.Context
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast

class LoginPageActivity : AppCompatActivity() {
    @SuppressLint("MissingInflatedId")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login_page)

        val textSignup=findViewById<TextView>(R.id.text_signup)
        val editUsername=findViewById<EditText>(R.id.login_email_input)
        val editPassword=findViewById<EditText>(R.id.login_pass_input)
        val loginBtn=findViewById<Button>(R.id.log_btn)


        val registerSharedPreferences = getSharedPreferences("userPref", Context.MODE_PRIVATE)
        val userName=registerSharedPreferences.getString("email","")
        val userPass=registerSharedPreferences.getString("password","")

        textSignup.setOnClickListener {
            startActivity(Intent(this,RegistrationPageActivity::class.java))
        }

        loginBtn.setOnClickListener {
            val user: String = editUsername.text.toString()
            val pass: String = editPassword.text.toString()
            if (userName==user && userPass==pass) {
                val edit = registerSharedPreferences.edit()
                edit.putBoolean("userlogin", true)
                edit.apply()
                val intent = Intent(this,HomeActivity::class.java)
                startActivity(intent)
                finish()
            }
            else{
                Toast.makeText(getApplicationContext(), "Username/Password Invalid", Toast.LENGTH_LONG).show();
            }
        }

    }
}