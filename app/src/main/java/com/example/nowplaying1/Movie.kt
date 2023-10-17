package com.example.nowplaying1

import android.media.Rating
import android.os.Parcelable
import androidx.annotation.Keep
import com.google.gson.annotations.SerializedName
import kotlinx.parcelize.IgnoredOnParcel
import kotlinx.parcelize.Parcelize
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable
import org.json.JSONArray

@Keep
@Serializable
data class Results(
    @SerialName("results")
    val results: List<Movie>?
)

@Keep
@Serializable
data class Movie (
    @SerialName("original_title")
    val movieTitle: String?,

    @SerialName("overview")
    val movieDescription: String?,

    @SerialName("poster_path")
    val imageURL: String?,

    @SerialName("original_language")
    val language: String?,

    @SerialName("release_date")
    val releaseDate: String?,

    @SerialName("vote_average")
    val rating: String?
): java.io.Serializable {
    val completeImgUrl = "https://image.tmdb.org/t/p/w500${imageURL}"
}


/*@Parcelize
data class Movie (
    val movieTitle: String,
    val movieDescription: String,
    val imageURL: String,

    val language: String,
    val releaseDate: String,
    val rating: String
):Parcelable {
    companion object{
        fun fromJson (resultsArray: JSONArray): List<Movie> {
            val movies = mutableListOf<Movie>()
            for (i in 0 until resultsArray.length()){
                val movieJson = resultsArray.getJSONObject(i)
                movies.add(
                    Movie(
                        movieJson.getString("original_title"),
                        movieJson.getString("overview"),
                        movieJson.getString("poster_path"),
                        movieJson.getString("original_language"),
                        movieJson.getString("release_date"),
                        movieJson.getString("vote_average")
                    )
                )
            }
            return movies
        }
    }
    @IgnoredOnParcel
    val completeImgUrl = "https://image.tmdb.org/t/p/w500${imageURL}"

}*/