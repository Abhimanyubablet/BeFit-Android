package com.example.befit

import android.annotation.SuppressLint
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button

class LandingPageActivity : AppCompatActivity() {
    @SuppressLint("MissingInflatedId", "SuspiciousIndentation")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_landing_page)

      val  registerBtn= findViewById<Button>(R.id.register_btn)

        registerBtn.setOnClickListener {
            startActivity(Intent(this,RegistrationPageActivity::class.java))
        }
    }
}