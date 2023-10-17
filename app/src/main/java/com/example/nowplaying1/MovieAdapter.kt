package com.example.nowplaying1

import android.content.Context
import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
private const val TAG = "MovieAdapter"
const val MOVIE_EXTRA = "MOVIE_EXTRA"

class MovieAdapter(private val context: Context, private val movies: MutableList<Movie>):
    RecyclerView.Adapter<MovieAdapter.ViewHolder>(){
    inner class  ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView), View.OnClickListener{
        private val moviePosterIV = itemView.findViewById<ImageView>(R.id.detailPosterIv)
        private val movieTitleTV = itemView.findViewById<TextView>(R.id.titleTv)
        private val movieOverviewTV = itemView.findViewById<TextView>(R.id.overviewTv)

        init {
            itemView.setOnClickListener(this)
        }

        fun bind(movie: Movie) {
            movieTitleTV.text = movie.movieTitle
            movieOverviewTV.text = movie.movieDescription

            Glide.with(context)
                .load(movie.completeImgUrl)
                .into(moviePosterIV)

        }

        override fun onClick(v: View?) {
            val movie = movies[adapterPosition]
            //Toast.makeText(context, movie.movieTitle,Toast.LENGTH_LONG).show()
            val intent = Intent(context, DetailActivity::class.java)
            intent.putExtra(MOVIE_EXTRA, movie)
            context.startActivity(intent)

            /*val activity = context as MainActivity
            // TODO: Get selected article
            val movie = movies[absoluteAdapterPosition]
            // TODO: Navigate to Details screen and pass selected article
            val intent = Intent(context, DetailActivity::class.java)
            intent.putExtra(ARTICLE_EXTRA, article)*/


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
