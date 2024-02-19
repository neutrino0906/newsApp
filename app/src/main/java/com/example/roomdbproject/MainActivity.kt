package com.example.roomdbproject

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import androidx.cardview.widget.CardView
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import kotlin.math.log

const val BASE_URL = "https://api.rss2json.com/v1/"


class MainActivity : AppCompatActivity(){
lateinit var myAdapter: MyAdapter
lateinit var myAdapter2 : MyAdapter2
private lateinit var linearLayoutManager: LinearLayoutManager
private lateinit var linearLayoutManager2: LinearLayoutManager
lateinit var recyclerView: RecyclerView
lateinit var recyclerView2: RecyclerView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        recyclerView = findViewById(R.id.recyclerView_news)
        recyclerView2 = findViewById(R.id.recyclerView_feed)


        recyclerView.setHasFixedSize(true)
        recyclerView2.setHasFixedSize(true)
        linearLayoutManager = LinearLayoutManager(this)
        linearLayoutManager2 = LinearLayoutManager(this)
        recyclerView.layoutManager = linearLayoutManager
        recyclerView2.layoutManager = linearLayoutManager2



        getMyData()

    }

    private fun getMyData() {
        val retrofitBuilder = Retrofit.Builder()
            .addConverterFactory(GsonConverterFactory.create())
            .baseUrl(BASE_URL)
            .build()
            .create(apiInterface::class.java)

        val retrofitData = retrofitBuilder.getData()

        retrofitData.enqueue(object : Callback<NewsData?> {
            override fun onResponse(
                call: Call<NewsData?>,
                response: Response<NewsData?>
            ) {

                val responseBody = response.body()!!



                myAdapter2 = MyAdapter2(baseContext, responseBody.feed)
                myAdapter = MyAdapter(baseContext, responseBody.items)
                recyclerView.adapter = myAdapter
                recyclerView2.adapter = myAdapter2


            }

            override fun onFailure(call: Call<NewsData?>, t: Throwable) {
                Log.d("MainActivity", "on failure: "+t.localizedMessage)
            }
        })
    }
}