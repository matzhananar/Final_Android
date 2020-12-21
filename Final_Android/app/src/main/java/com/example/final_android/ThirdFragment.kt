package com.example.final_android

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import kotlinx.android.synthetic.main.third_page.*
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class ThirdFragment: Fragment() {
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.third_page, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val country = arguments?.getString("country")!!

        MainActivity.apiService.getNews(country).enqueue(object: Callback<News> {
            override fun onFailure(call: Call<News>, t: Throwable) {
                Log.e("error", t.message.toString())
            }
            override fun onResponse(call: Call<News>, response: Response<News>) {
                Log.e("Response body: ", response.body()!!.toString())
                val news = response.body()!!
                title.text = news.title
                author.text = news.author
            }
        })
    }

}