package com.example.wallpaper

import android.content.Context
import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide

class AdaptarCuratedImg(val ctx: Context,val arrPhotos:ArrayList<PhotoModel>):RecyclerView.Adapter<AdaptarCuratedImg.ViewHolder>() {
    class ViewHolder(val view:View):RecyclerView.ViewHolder(view) {
        val searchImg = view.findViewById<ImageView>(R.id.imageViewRecyCurated)

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
       return ViewHolder(LayoutInflater.from(ctx).inflate(R.layout.row_images_bestofmonth,parent,false))
    }

    override fun getItemCount(): Int {
       return arrPhotos.size
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.itemView.setOnClickListener {
            ctx.startActivity(Intent(ctx,FullScreenWallpaperActivity::class.java).putExtra("IMG",arrPhotos[position].src.portrait))
        }
        Glide.with(ctx).load(arrPhotos[position].src.portrait).into(holder.searchImg)
    }
}