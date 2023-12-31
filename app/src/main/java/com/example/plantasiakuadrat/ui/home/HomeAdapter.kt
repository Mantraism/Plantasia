package com.example.plantasiakuadrat.ui.home

import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.plantasiakuadrat.R
import com.example.plantasiakuadrat.data.remote.response.Data


class HomeAdapter(private val list : List<Data>):RecyclerView.Adapter<HomeAdapter.MyViewHolder>() {
    inner class MyViewHolder(view : View):RecyclerView.ViewHolder(view){
        val title: TextView = view.findViewById(R.id.title_rv)
        val image: ImageView = view.findViewById(R.id.image_rv)
        val latinname : TextView = view.findViewById(R.id.latinname_rv)
        val bibliography : TextView = view.findViewById(R.id.bibliography)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.item_plant, parent, false)
        return MyViewHolder(view)
    }

    override fun getItemCount(): Int {
        Log.d("title","Response : $list")
        return list.size
    }

    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
        holder.title.text = list[position].common_name
        holder.latinname.text = list[position].scientific_name
        holder.bibliography.text = list[position].bibliography
        Log.d("title","Response : $holder")
        // Assuming defaultImage is a property of your data class that holds image information
        val imageUrl = list[position].image_url
        Glide.with(holder.itemView.context)
            .load(imageUrl)
            .into(holder.image)
    }
}