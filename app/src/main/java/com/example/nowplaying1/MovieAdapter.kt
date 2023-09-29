package com.example.nowplaying1

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide

class MovieAdapter(private val context: Context, private val movies: MutableList<Movie>):
    RecyclerView.Adapter<MovieAdapter.ViewHolder>(){
    inner class  ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView){
        private val moviePosterIV = itemView.findViewById<ImageView>(R.id.posterIV)
        private val movieTitleTV = itemView.findViewById<TextView>(R.id.titleTv)
        private val movieOverviewTV = itemView.findViewById<TextView>(R.id.overviewTv)

        fun bind(movie: Movie) {
            movieTitleTV.text = movie.movieTitle
            movieOverviewTV.text = movie.movieDescription

            Glide.with(context)
                .load(movie.completeImgUrl)
                .into(moviePosterIV)

        }

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(context).inflate(R.layout.movie_item,parent,false)
        return ViewHolder(view)

    }

    override fun getItemCount(): Int {
        return movies.size
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val movie = movies[position]
        holder.bind(movie)
    }
}
