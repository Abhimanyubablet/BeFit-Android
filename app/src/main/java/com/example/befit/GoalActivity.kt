package com.example.befit

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button

class GoalActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_goal)

        val btnContinue=findViewById<Button>(R.id.btn_continue)

        btnContinue.setOnClickListener {
            startActivity(Intent(this,HomeActivity::class.java))
        }

    }
}