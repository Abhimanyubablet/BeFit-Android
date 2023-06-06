package com.example.befit

import android.annotation.SuppressLint
import android.content.Context
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.FrameLayout
import android.widget.ImageView
import android.widget.TextView
import androidx.fragment.app.Fragment
import androidx.viewpager.widget.ViewPager
import com.google.android.material.bottomnavigation.BottomNavigationView
import com.google.android.material.tabs.TabLayout

class HomeActivity : AppCompatActivity() {
    @SuppressLint("MissingInflatedId")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_home)

        val navigationBtn=findViewById<BottomNavigationView>(R.id.navigation_view)
        loadFragment(HomeFragment())
        navigationBtn.setOnItemSelectedListener {
            when (it.itemId){
                R.id.bottom_home -> loadFragment(HomeFragment())
                R.id.bottom_search -> loadFragment(SearchFragment())
                R.id.bottom_setting -> loadFragment(SettingFragment())
                R.id.bottom_profile -> loadFragment(ProfileFragment())

            }
            true
        }
    }

    private fun loadFragment (fragment: Fragment){
        supportFragmentManager.beginTransaction().replace(R.id.framelaout,fragment).commit()
    }
}


