package com.example.befit

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.fragment.app.FragmentActivity
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide

class RecyclerAdapter(val context: FragmentActivity?, val datalist:List<DataModel>) : RecyclerView.Adapter<RecyclerAdapter.ViewHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerAdapter.ViewHolder {
        val View = LayoutInflater.from(parent.context).inflate(R.layout.recycler_customer_list_view,parent,false)
        return ViewHolder(View)
    }

    override fun onBindViewHolder(holder: RecyclerAdapter.ViewHolder, position: Int) {
        val data=datalist[position]
        holder.month.text=data.month
        holder.title.text=data.title
        Glide.with(context!!).load(data.image).into(holder.image)

    }

    override fun getItemCount(): Int {
        return datalist.size
    }
    class ViewHolder(itemView: View):RecyclerView.ViewHolder(itemView){
        val image=itemView.findViewById<ImageView>(R.id.image)
        val title=itemView.findViewById<TextView>(R.id.title)
        val month=itemView.findViewById<TextView>(R.id.month)
    }
}
