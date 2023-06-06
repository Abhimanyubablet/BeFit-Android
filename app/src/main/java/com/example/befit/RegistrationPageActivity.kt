package com.example.befit

import android.annotation.SuppressLint
import android.content.Context
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView

class RegistrationPageActivity : AppCompatActivity() {
    @SuppressLint("MissingInflatedId", "CommitPrefEdits")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_registration_page)


        val  userEmailInput = findViewById<EditText>(R.id.user_email_input)
        val userPassInput = findViewById<EditText>(R.id.user_pass_input)
        val  userRepeatPassInput = findViewById<EditText>(R.id.user_repeat_pass_input)
        val signUpBtn=findViewById<Button>(R.id.signup_btn)
        val signIn=findViewById<TextView>(R.id.text_sign_in)

        val sharedPreferences = getSharedPreferences("userPref", Context.MODE_PRIVATE)
        val editProof = sharedPreferences.edit()

        signUpBtn.setOnClickListener {
            editProof.putBoolean("userlogin", true)
            editProof.apply()
            editProof.putString("email", userEmailInput.text.toString())
            editProof.putString("password",userPassInput.text.toString())
            editProof.putString("repeat_password", userRepeatPassInput.text.toString()).apply()
            startActivity(Intent(this,UserGenderActivity::class.java))
        }

        signIn.setOnClickListener {
            startActivity(Intent(this,LoginPageActivity::class.java))
        }

    }
}