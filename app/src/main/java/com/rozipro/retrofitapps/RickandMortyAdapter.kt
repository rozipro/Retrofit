package com.rozipro.retrofitapps

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import android.widget.Toast
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.bumptech.glide.GlideContext
import com.rozipro.retrofitapps.ResultsItem
import com.rozipro.retrofit.R

class RickandMortyAdapter(val dataRickandMorty: List<ResultsItem>): RecyclerView.Adapter<RickandMortyAdapter.MyViewHolder>() {
    class MyViewHolder(view : View):RecyclerView.ViewHolder(view) {
        val imgRick = view.findViewById<ImageView>(R.id.item_image_Rick)
        val nameRIck = view.findViewById<TextView>(R.id.item_name_rick)
        val statusRick = view.findViewById<TextView>(R.id.item_status_rick)
        val speciesRick = view.findViewById<TextView>(R.id.item_species_rick)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.item_character,parent,false)
        return MyViewHolder(view)
    }

    override fun getItemCount(): Int {
        if (dataRickandMorty != null){
            return  dataRickandMorty.size
        }
        return 0
    }

    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
        holder.nameRIck.text = dataRickandMorty?.get(position)?.name
        holder.statusRick.text = dataRickandMorty?.get(position)?.status
        holder.speciesRick.text = dataRickandMorty?.get(position)?.species

        Glide.with(holder.imgRick)
            .load(dataRickandMorty?.get(position)?.image)
            .error(R.drawable.ic_launcher_background)
            .into(holder.imgRick)

        holder.itemView.setOnClickListener{
            val name = dataRickandMorty?.get(position)?.name
            Toast.makeText(holder.itemView.context,"${name}",Toast.LENGTH_SHORT).show()
        }
    }
}