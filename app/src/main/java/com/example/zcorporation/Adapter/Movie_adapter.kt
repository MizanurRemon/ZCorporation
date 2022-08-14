package com.example.zcorporation.Adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import coil.load
import com.example.zcorporation.Model.Movie_response
import com.example.zcorporation.R

class Movie_adapter(val movieList: List<Movie_response.Results>) :
    RecyclerView.Adapter<Movie_adapter.ViewHolder>() {
    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): ViewHolder {
        val view =
            LayoutInflater.from(parent.context).inflate(R.layout.movie_card, parent, false)
        return ViewHolder(view)
    }

    override fun onBindViewHolder(holder: Movie_adapter.ViewHolder, position: Int) {
        holder.bindItems(movieList[position])
    }

    override fun getItemCount(): Int {
        return movieList.size
    }

    class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {

        fun bindItems(movieData: Movie_response.Results) {

            var base_link = "https://image.tmdb.org/t/p/w600_and_h900_bestv2"
            val titleText: TextView = itemView.findViewById(R.id.titleText)
            val coverImage: ImageView = itemView.findViewById(R.id.coverImage)

            titleText.text = movieData.title
            coverImage.load(base_link + movieData.posterPath)
        }
    }
}