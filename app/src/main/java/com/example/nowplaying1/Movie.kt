package com.example.nowplaying1

import com.google.gson.annotations.SerializedName
import org.json.JSONArray


data class Movie (
    val movieTitle: String,
    val movieDescription: String,
    val imageURL: String
){
    companion object{
        fun fromJson (resultsArray: JSONArray): List<Movie> {
            val movies = mutableListOf<Movie>()
            for (i in 0 until resultsArray.length()){
                val movieJson = resultsArray.getJSONObject(i)
                movies.add(
                    Movie(
                        movieJson.getString("original_title"),
                        movieJson.getString("overview"),
                        movieJson.getString("poster_path")
                    )
                )
            }
            return movies
        }
    }
    val completeImgUrl = "https://image.tmdb.org/t/p/w500${imageURL}"

}