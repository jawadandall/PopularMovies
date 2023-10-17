package com.example.nowplaying1

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ImageView
import android.widget.TextView
import com.bumptech.glide.Glide

private lateinit var posterImageView: ImageView
private lateinit var titleTextView: TextView
private lateinit var overviewTextView: TextView
private lateinit var dateTextView: TextView
private lateinit var languageTextView: TextView
private lateinit var ratingTextView: TextView
class DetailActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_detail)

        val movies: MutableList<Movie>

        titleTextView = findViewById(R.id.detailTitleTv)
        overviewTextView = findViewById(R.id.detailOverviewTv)
        dateTextView = findViewById(R.id.releaseDateTv)
        languageTextView =findViewById(R.id.languageTv)
        ratingTextView = findViewById(R.id.ratingTv)
        posterImageView= findViewById(R.id.detailPosterIv)

        val movie = intent.getSerializableExtra(MOVIE_EXTRA) as Movie

        titleTextView.text = movie.movieTitle
        overviewTextView.text = movie.movieDescription
        dateTextView.text = "Release Date: "
        dateTextView.append(movie.releaseDate)
        languageTextView.text= "Language: "
        languageTextView.append(movie.language)
        ratingTextView.text =" Movie Rating: "
        ratingTextView.append(movie.rating)


        Glide.with(this)
            .load(movie.completeImgUrl)
            .into(posterImageView)

    }
}