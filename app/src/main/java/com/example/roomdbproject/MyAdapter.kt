package com.example.roomdbproject

//import android.R
import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.squareup.picasso.Picasso



class MyAdapter(private val context : Context, private val newsList: List<Item>) : RecyclerView.Adapter<MyAdapter.ViewHolder>(), RecyclerViewInterface {
    class ViewHolder(itemView: View): RecyclerView.ViewHolder(itemView) {

        var title : TextView
        var author : TextView
        var imageView : ImageView


        init {
            title = itemView.findViewById(R.id.title)
            author = itemView.findViewById(R.id.author)
            imageView = itemView.findViewById(R.id.thumbnail)
        }

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val itemView = LayoutInflater.from(context).inflate(R.layout.row_items, parent, false)
        return ViewHolder(itemView)
    }

    override fun getItemCount(): Int {
        return newsList.size
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {

        holder.itemView.setOnClickListener(View.OnClickListener {
            RecyclerViewInterface.onClick(context, newsList[position].author, newsList[position].title, newsList[position].description, newsList[position].thumbnail)
        })

        holder.title.text = newsList[position].title
        holder.author.text = newsList[position].author
        try{
            Picasso.get()
                .load(newsList[position].thumbnail)
                .placeholder(R.drawable.placeholder_image)
                .into(holder.imageView)
        }catch (e: Exception){
            Picasso.get()
                .load("https://drive.google.com/file/d/1SYzxLYIih039Eaw-7iL7ruYzMGnMn_P3/view?usp=sharing")
                .placeholder(R.drawable.placeholder_image)
                .into(holder.imageView)
        }

    }

}

class MyAdapter2(val context: Context, val feed: Feed) : RecyclerView.Adapter<MyAdapter2.ViewHolder>() {
    class ViewHolder(itemView: View): RecyclerView.ViewHolder(itemView) {
        val author : TextView
        val title : TextView
        val imageView: ImageView

        init {
            imageView = itemView.findViewById(R.id.thumbnail)
            author = itemView.findViewById(R.id.author)
            title = itemView.findViewById(R.id.title)


        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val itemView = LayoutInflater.from(context).inflate(R.layout.row_items, parent, false)
        return ViewHolder(itemView)
    }

    override fun getItemCount(): Int {
        return 1
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.author.text = feed.author
        holder.title.text = feed.title
        Picasso.get()
            .load(feed.image)
            .placeholder(R.drawable.placeholder_image)
            .into(holder.imageView)


    }
}