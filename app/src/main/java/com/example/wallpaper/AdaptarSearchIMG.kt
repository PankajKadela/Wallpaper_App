package com.example.wallpaper

import android.content.Context
import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide

class AdaptarSearchIMG(val ctx:Context, val arrListSearch:ArrayList<PhotoModel>):RecyclerView.Adapter<AdaptarSearchIMG.ViewHolder>() {
    class ViewHolder(val view:View):RecyclerView.ViewHolder(view) {
        val imgSearch = view.findViewById<ImageView>(R.id.imageViewSearchRow)

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        return ViewHolder(LayoutInflater.from(ctx).inflate(R.layout.row_search_wallpaper,parent,false))
    }

    override fun getItemCount(): Int {
        return arrListSearch.size
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.itemView.setOnClickListener{
          ctx.startActivity(Intent(ctx,FullScreenWallpaperActivity::class.java).putExtra("IMG",arrListSearch[position].src.portrait))
        }
          Glide.with(ctx).load(arrListSearch[position].src.portrait).into(holder.imgSearch)
    }
}