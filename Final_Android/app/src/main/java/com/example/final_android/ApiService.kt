package com.example.final_android

import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Path

interface APIService {
    @GET("category/{category}/{country}")
    fun getNews(country: String): Call<News>

    @GET("category/{category}/{country")
    fun getPostById(@Path("id") Id: Int): Call<Country>

    @GET("posts/{id}/comments/")
    fun getCommentsById(@Path("id") commentId: Int): Call<MutableList<Country>>

}