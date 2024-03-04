package com.example.roomdbproject

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import com.squareup.picasso.Picasso
import org.w3c.dom.Text


class MainActivity3 : AppCompatActivity() {

    private lateinit var author : TextView
    private lateinit var title : TextView
    private lateinit var desc : TextView
    private lateinit var image : ImageView
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main3)

        var authorText  =""
        if (intent !=null)
        if (intent.hasExtra("authorName")){
            authorText = intent.extras?.getString("authorName").toString()
        }
        

        val titleText : String? = intent.extras?.getString("title")
        val descriptionText : String? = intent.extras?.getString("description")
        val imageLink : String? = intent.extras?.getString("imageLink")

        author = findViewById(R.id.new_author)
        title = findViewById(R.id.new_title)
        desc = findViewById(R.id.new_description)
        image = findViewById(R.id.new_image)
        var isFullScreen = false


        if(authorText!="") author.text = "-By $authorText"
        else author.text = "-By Anonymous"
        title.text = titleText
        desc.text = descriptionText

        Picasso.get()
            .load(imageLink)
            .placeholder(R.drawable.placeholder_image)
            .into(image)

//        image.setOnClickListener {
//            if (isFullScreen) {
//                isFullScreen = false
//                image.layoutParams = ViewGroup.LayoutParams(
//                    ViewGroup.LayoutParams.WRAP_CONTENT,
//                    ViewGroup.LayoutParams.WRAP_CONTENT
//                )
//                image.adjustViewBounds = true
//
//            } else {
//                isFullScreen = true
//                image.layoutParams = ViewGroup.LayoutParams(
//                    ViewGroup.LayoutParams.MATCH_PARENT,
//                    ViewGroup.LayoutParams.MATCH_PARENT
//                )
//                image.scaleType = ImageView.ScaleType.CENTER
//            }
//
//
//        }

    }
}


