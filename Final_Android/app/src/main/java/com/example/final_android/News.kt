package com.example.final_android

import com.google.gson.annotations.SerializedName

data class News(
    @SerializedName("status")
    val status: String,
    @SerializedName("totalResults")
    val totalResults: Int,
    @SerializedName("author")
    val author: String,
    @SerializedName("description")
    val description: String,
    @SerializedName("title")
    val title: String
)