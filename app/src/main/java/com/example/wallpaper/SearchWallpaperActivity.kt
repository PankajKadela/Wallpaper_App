package com.example.wallpaper

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import androidx.recyclerview.widget.GridLayoutManager
import com.example.wallpaper.apiHelper.ApiHelper
import com.example.wallpaper.databinding.ActivitySearchWallpaperBinding
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class SearchWallpaperActivity : AppCompatActivity() {
    lateinit var binding : ActivitySearchWallpaperBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivitySearchWallpaperBinding.inflate(layoutInflater)
        setContentView(binding.root)
        val arrListSearchImg = ArrayList<PhotoModel>()


      val userSearch = intent.getStringExtra("search")

        val apiHelper = ApiHelper

        apiHelper.create().getAllPhotos(userSearch!!,"50").enqueue(object : Callback<WallpaperMode>{
            override fun onResponse(call: Call<WallpaperMode>, response: Response<WallpaperMode>) {
               if (response.code()==200){

                   binding.recySearchIMG.layoutManager = GridLayoutManager(this@SearchWallpaperActivity,2)
                 binding.recySearchIMG.adapter  = AdaptarSearchIMG(this@SearchWallpaperActivity,response.body()!!.photos)
               }
            }

            override fun onFailure(call: Call<WallpaperMode>, t: Throwable) {
                Log.d("Fail HOGYA",t.message.toString())
                t.printStackTrace()
            }

        })

    }
}