package com.example.roomdbproject

import android.app.Activity
import android.content.Context
import android.content.Intent
import android.util.Log

interface RecyclerViewInterface {
//    abstract fun onClick(pos: Int)

    companion object{
        fun onClick(context : Context, authorName: String, title: String, desc: String, link: String){
            val intent  = Intent(context, MainActivity3::class.java)

            intent.putExtra("authorName", authorName)
            intent.putExtra("title", title)
            intent.putExtra("description", desc)
            intent.putExtra("imageLink", link)

            intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK)
            context.startActivity(intent)


        }

    }
}