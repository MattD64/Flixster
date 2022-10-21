package com.example.flixsterplus

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide

class MovieAdapter(private val movies: List<Movie>) : RecyclerView.Adapter<MovieAdapter.ViewHolder>() {

    inner class ViewHolder(itemView : View) : RecyclerView.ViewHolder(itemView){
        val ivPoster = itemView.findViewById<ImageView>(R.id.ivPoster)
        val tvTitle = itemView.findViewById<TextView>(R.id.tvTitle)
        val tvOverview = itemView.findViewById<TextView>(R.id.tvOverview)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val context = parent.context
        val inFlater = LayoutInflater.from(context)

        val movieView = inFlater.inflate(R.layout.movie_item, parent, false)
        return ViewHolder(movieView)
    }

    override fun onBindViewHolder(viewHolder: MovieAdapter.ViewHolder, position: Int) {
        val movie = movies[position]

        val tvTitle = viewHolder.tvTitle
        val tvOverview = viewHolder.tvOverview
        val ivPoster = viewHolder.ivPoster

        tvTitle.text = movie.title
        tvOverview.text = movie.overview
        Glide.with(ivPoster)
            .load(movie.posterImageURL)
            .centerCrop()
            .into(ivPoster)
    }

    override fun getItemCount(): Int {
      return movies.size
    }

}