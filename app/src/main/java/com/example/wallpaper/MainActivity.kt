package com.example.wallpaper

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.wallpaper.apiHelper.ApiHelper
import com.example.wallpaper.databinding.ActivityMainBinding
import com.example.wallpaper.model.CatModel
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class MainActivity : AppCompatActivity() {
    companion object{
        val arrListOfCat = ArrayList<CatModel>().apply {
            add(CatModel(1,R.drawable.abs,"ABSTRACT"))
            add(CatModel(2,R.drawable.animals,"ANIMALS"))
            add(CatModel(3,R.drawable.dark,"DARK"))
            add(CatModel(4,R.drawable.cars,"CARS"))
            add(CatModel(5,R.drawable.cartoons,"CARTOONS"))
            add(CatModel(6,R.drawable.food,"FOOD"))
            add(CatModel(7,R.drawable.game,"GAME"))
            add(CatModel(8,R.drawable.gradient,"GRADIENT"))
            add(CatModel(9,R.drawable.plants,"PLANTS"))
            add(CatModel(10,R.drawable.sad,"SAD"))
            add(CatModel(11,R.drawable.anime,"ANIMIE"))

        }

    }

    lateinit var binding: ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.recyclerViewCat.layoutManager = GridLayoutManager(this,2)
        binding.recyclerViewCat.adapter = AdaptarCatImages(this,arrListOfCat)


        binding.textViewSeeAllCatagory.setOnClickListener {
            startActivity(Intent(this@MainActivity,SeeAllCategoryActivity::class.java))

        }


        binding.textViewSellAllCurated.setOnClickListener{

            startActivity(Intent(this@MainActivity,CuratedWallpaperActivity::class.java)
                .putExtra("curated","CURATED"))
        }



        binding.SearchBTN.setOnClickListener{
            val userSearchTxt = binding.editTextSearch.text.toString()
            if (userSearchTxt != ""){

                  startActivity(Intent(this@MainActivity,SearchWallpaperActivity::class.java)
                      .putExtra("search",userSearchTxt))
                binding.editTextSearch.text.clear()
            }
        }



        val apiHelper = ApiHelper

        apiHelper.create().getProducts("10").enqueue(object :Callback<WallpaperMode>{
            override fun onResponse(call: Call<WallpaperMode>, response: Response<WallpaperMode>) {

                if (response.code()==200){
                    Log.d("Wallpaper URl","$response.body()!!.photos")
                    binding.recyclerViewCurated.layoutManager = LinearLayoutManager(this@MainActivity,LinearLayoutManager.HORIZONTAL,false)
                     binding.recyclerViewCurated.adapter = AdaptarCuratedImg(this@MainActivity,response.body()!!.photos)
                }
            }

            override fun onFailure(call: Call<WallpaperMode>, t: Throwable) {
               Log.d("No Wall LOAD",t.message.toString())
                t.printStackTrace()
            }

        })
    }
}