package com.example.booksapp.data.model

import com.google.gson.annotations.SerializedName

data class BookDetail(
    val id:Int?,
    val name:String?,
    val price:Double?,
    val publisher:String?,
    val author:String?,
    @SerializedName("image_url") val imageUrl:String?,
    @SerializedName("best_seller") val bestSeller:Boolean?,

)
