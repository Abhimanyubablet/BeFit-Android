package com.example.befit

import android.annotation.SuppressLint
import android.content.Context
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.RecyclerView


class ProfileFragment : Fragment() {

    @SuppressLint("MissingInflatedId")
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        val rowView=inflater.inflate(R.layout.fragment_profile, container, false)

        val sharedPreferences = activity?.getSharedPreferences("userPref", Context.MODE_PRIVATE)
        val name =rowView. findViewById<TextView>(R.id.Text_name)
//        val pass = rowView.findViewById<TextView>(R.id.Text_pass)

        name.text = sharedPreferences?.getString("email", "Q@gmail.com").toString()
//        pass.text = sharedPreferences?.getString("password", "000").toString()



        val data= arrayListOf<DataModel>(
            DataModel("abhimanyu","11","https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcR_kOmHCwMJ7gkyfRp6A6Cmyrs4tC9SyXoZYLTOBGUL2w&usqp=CAU&ec=48600112")
            , DataModel("nitesh","09","https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcRMz7DYsWaEvb20In9BQPZ5C6ofq3r7z5Hmg7l1y6sXlw&usqp=CAU&ec=48600112")
            , DataModel("rahul","09","https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcR_ePToC9tS-dGTM5feLidy9ZGFnDXeWFBOTs9YGyjhqg&usqp=CAU&ec=48600112")
            , DataModel("nikhil","01","https://assets.gqindia.com/photos/5dede9191d798400088dbdd3/16:9/pass/The-best-back-workouts-you'll-ever-have.jpg")
            , DataModel("aman","03","https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcTXOX0NhRClolbZ-HGN17-yGplAh4OVzq5Mq5-SFRec6w&usqp=CAU&ec=48600112")
            , DataModel("sahil","08","https://www.shutterstock.com/image-photo/photo-handsome-young-sporty-man-260nw-389938903.jpg")
            , DataModel("golu","17","https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcSMWMwlcDV8Jernh4lgRuwmnm190VhSIqKC7pD3GEBOAA&usqp=CAU&ec=48600112")


        )
        val recyclerView=rowView.findViewById<RecyclerView>(R.id.recyclerview)
        recyclerView.layoutManager= GridLayoutManager(activity,1)
        val recyclerAdapter=RecyclerAdapter(activity,data)
        recyclerView.adapter=recyclerAdapter
        return rowView
    }



    }


