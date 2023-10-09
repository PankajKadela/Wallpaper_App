package com.example.wallpaper

import android.content.Context
import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.wallpaper.model.CatModel
import com.example.wallpaper.screen.CategoryWallpaperShowActivity

class AdaptarCatImages(val ctx:Context, val arrCatList : ArrayList<CatModel>) : RecyclerView.Adapter<AdaptarCatImages.ViewHolder>() {
    class ViewHolder(val view:View):RecyclerView.ViewHolder(view) {
        val imgCat = view.findViewById<ImageView>(R.id.imageViewCatRecyRow)
        val catTitle = view.findViewById<TextView>(R.id.textViewCatRecyRow)

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
       return ViewHolder(LayoutInflater.from(ctx).inflate(R.layout.row_img_catagory,parent,false))
    }

    override fun getItemCount(): Int {
        return arrCatList.size
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
          holder.itemView.setOnClickListener{
              ctx.startActivity(Intent(ctx,CategoryWallpaperShowActivity::class.java).putExtra("categoryText",arrCatList[position].catTitle))
          }

        holder.imgCat.setImageResource(arrCatList[position].imaCat)
        holder.catTitle.text = arrCatList[position].catTitle
    }
}