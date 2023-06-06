package com.example.befit

import android.annotation.SuppressLint
import android.content.Context
import android.content.Intent
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.viewpager.widget.ViewPager
import com.google.android.material.tabs.TabLayout

class HomeFragment : Fragment() {



    @SuppressLint("MissingInflatedId")
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment

        val rowView= inflater.inflate(R.layout.fragment_home, container, false)

        val logoutBtn=rowView.findViewById<ImageView>(R.id.logout)
        val tabLayaout=rowView.findViewById<TabLayout>(R.id.tabLayout)
        val viewPager=rowView.findViewById<ViewPager>(R.id.viewpage)

        val sharedPreferences =activity?.getSharedPreferences("userPref", Context.MODE_PRIVATE)
        val name = rowView.findViewById<TextView>(R.id.user_name)
        name.text = sharedPreferences?.getString("email", "abc@gmail.com").toString()

        logoutBtn.setOnClickListener {
            val editUserPref = sharedPreferences?.edit()
            editUserPref?.putBoolean("userlogin", false)
            editUserPref?.apply()
            startActivity(Intent(activity,LoginPageActivity::class.java))
        }


        val adapter= activity?.let { TabAdapter(it.supportFragmentManager) }
        adapter?.addFragment(DiscoverFragment(),"Discover")
        adapter?.addFragment(TrainerFragment(),"Trainers")
        adapter?.addFragment(PlanFragment(),"My plan")

        viewPager.adapter=adapter
        tabLayaout.setupWithViewPager(viewPager)

     return  rowView

    }


}