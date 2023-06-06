package com.example.befit

import android.content.Context
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Handler

class SplashActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.splash_main)

      Handler().postDelayed({
          startActivity(Intent(this,LandingPageActivity::class.java))

          val splashSharedPreferences = getSharedPreferences("userPref", Context.MODE_PRIVATE)
          val loginStatus = splashSharedPreferences.getBoolean("userlogin", false)
          if (loginStatus) {
              val intent = Intent(this, HomeActivity::class.java)
              startActivity(intent)
              finish()
          }else{
              val intent = Intent(this, LoginPageActivity::class.java)
              startActivity(intent)
              finish()
          }
      },2000)


    }
}