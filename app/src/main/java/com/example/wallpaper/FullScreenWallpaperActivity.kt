package com.example.wallpaper

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.bumptech.glide.Glide
import com.example.wallpaper.databinding.ActivityFullScreenWallpaperBinding

class FullScreenWallpaperActivity : AppCompatActivity() {

    lateinit var binding : ActivityFullScreenWallpaperBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityFullScreenWallpaperBinding.inflate(layoutInflater)
        setContentView(binding.root)



        val searchImg = intent.getStringExtra("IMG")
        Glide.with(this).load(searchImg).into(binding.imageViewFullScreenWall)
    }
}