package com.example.wallpaper

import android.content.Context
import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide


class AdaptarCatIWallpapers(val ctx : Context, val arrCatWallpaperList : ArrayList<PhotoModel>):RecyclerView.Adapter<AdaptarCatIWallpapers.ViewHolder>() {
    class ViewHolder(val view:View):RecyclerView.ViewHolder(view) {
        val CatImagWallView = view.findViewById<ImageView>(R.id.imageViewSearchRow)

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        return ViewHolder(LayoutInflater.from(ctx).inflate(R.layout.row_search_wallpaper,parent,false))
    }

    override fun getItemCount(): Int {
        return arrCatWallpaperList.size
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.itemView.setOnClickListener {
            ctx.startActivity(Intent(ctx,FullScreenWallpaperActivity::class.java).putExtra("IMG",arrCatWallpaperList[position].src.portrait))
        }

        Glide.with(ctx).load(arrCatWallpaperList[position].src.portrait).into(holder.CatImagWallView)
    }
}