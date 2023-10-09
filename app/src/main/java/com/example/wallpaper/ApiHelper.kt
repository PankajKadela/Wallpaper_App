package com.example.wallpaper.apiHelper

import com.example.wallpaper.WallpaperMode
import retrofit2.Call
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.http.GET
import retrofit2.http.Headers
import retrofit2.http.Query

interface ApiHelper {

    companion object{

        var BASE_URL  = "https://api.pexels.com/v1/"

        fun create() : ApiHelper {

            val retrofit = Retrofit
                .Builder()
                .baseUrl(BASE_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .build()
            return retrofit.create(ApiHelper::class.java)

        }
    }

    @GET("search")
    @Headers("Authorization: dRSe4HHGsNBvu2XDa1lr3Dq4KR5cbxNReFoajnDYEJFgWRPwAwyis4A3")
    abstract fun getAllPhotos(@Query("query") search:String, @Query("per_page") per_page:String):Call<WallpaperMode>



    @GET("curated") @Headers("Authorization: dRSe4HHGsNBvu2XDa1lr3Dq4KR5cbxNReFoajnDYEJFgWRPwAwyis4A3")
    abstract fun getProducts(@Query("per_page") per_page: String): Call<WallpaperMode>
}
