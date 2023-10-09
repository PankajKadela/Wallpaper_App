package com.example.wallpaper.screen

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.GridLayoutManager
import com.example.wallpaper.AdaptarCatIWallpapers
import com.example.wallpaper.PhotoModel
import com.example.wallpaper.R
import com.example.wallpaper.WallpaperMode
import com.example.wallpaper.apiHelper.ApiHelper
import com.example.wallpaper.databinding.ActivityCategoryWallpaperShowBinding
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class CategoryWallpaperShowActivity : AppCompatActivity() {
    lateinit var binding: ActivityCategoryWallpaperShowBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityCategoryWallpaperShowBinding.inflate(layoutInflater)
        setContentView(binding.root)
        val arrCatListWall = ArrayList<PhotoModel>()

        val catagoryText = intent.getStringExtra("categoryText")

        val apiHelper = ApiHelper.create().getAllPhotos(catagoryText!!,"50").enqueue(object :
            Callback<WallpaperMode>{
            override fun onResponse(call: Call<WallpaperMode>, response: Response<WallpaperMode>) {

                binding.RecyclerCatWallpaper.layoutManager = GridLayoutManager(this@CategoryWallpaperShowActivity,2)
                binding.RecyclerCatWallpaper.adapter = AdaptarCatIWallpapers(this@CategoryWallpaperShowActivity,response.body()!!.photos)


            }

            override fun onFailure(call: Call<WallpaperMode>, t: Throwable) {

            }

        })



    }
}