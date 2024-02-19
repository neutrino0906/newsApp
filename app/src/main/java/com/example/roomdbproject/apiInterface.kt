package com.example.roomdbproject

import retrofit2.Call
import retrofit2.http.GET

interface apiInterface {

    @GET("api.json?rss_url=http://www.abc.net.au/news/feed/51120/rss.xml")
    fun getData(): Call<NewsData>
}