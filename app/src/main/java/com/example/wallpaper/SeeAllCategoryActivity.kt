package com.example.wallpaper

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.GridLayoutManager
import com.example.wallpaper.MainActivity.Companion.arrListOfCat
import com.example.wallpaper.databinding.ActivitySeeAllCategoryBinding

class SeeAllCategoryActivity : AppCompatActivity() {
    lateinit var binding: ActivitySeeAllCategoryBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivitySeeAllCategoryBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.RecyclerViewSellAllCategory.layoutManager = GridLayoutManager(this,2)
        binding.RecyclerViewSellAllCategory.adapter = AdaptarCatImages(this,arrListOfCat)

    }
}