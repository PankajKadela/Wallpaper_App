package com.example.wallpaper

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.GridLayoutManager
import com.example.wallpaper.apiHelper.ApiHelper
import com.example.wallpaper.databinding.ActivityCuratedWallpaperBinding
import com.example.wallpaper.model.CatModel
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class CuratedWallpaperActivity : AppCompatActivity() {


    lateinit var binding: ActivityCuratedWallpaperBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityCuratedWallpaperBinding.inflate(layoutInflater)
        setContentView(binding.root)








        val arrLstCurated = ArrayList<PhotoModel>()


            var apiHelper =
                ApiHelper.create().getProducts("50").enqueue(object : Callback<WallpaperMode> {
                    override fun onResponse(
                        call: Call<WallpaperMode>,
                        response: Response<WallpaperMode>
                    ) {
                        if (response.code() == 200) {
                            binding.RecyCuraatedActicity.layoutManager =
                                GridLayoutManager(this@CuratedWallpaperActivity, 2)
                            binding.RecyCuraatedActicity.adapter = AdaptarCuratedImg(
                                this@CuratedWallpaperActivity,
                                response.body()!!.photos
                            )
                        }
                    }

                    override fun onFailure(call: Call<WallpaperMode>, t: Throwable) {

                    }

                })

    }
}