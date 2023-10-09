package com.example.wallpaper

data class WallpaperMode(
    val next_page: String,
    val page: Int,
    val per_page: Int,
    val photos: ArrayList<PhotoModel>,
    val total_results: Int
)
data class PhotoModel(
    val alt: String,
    val avg_color: String,
    val height: Int,
    val id: Int,
    val liked: Boolean,
    val photographer: String,
    val photographer_id: Int,
    val photographer_url: String,
    val src: SrcModel,
    val url: String,
    val width: Int
)
data class SrcModel(
    val landscape: String,
    val large: String,
    val large2x: String,
    val medium: String,
    val original: String,
    val portrait: String,
    val small: String,
    val tiny: String
)