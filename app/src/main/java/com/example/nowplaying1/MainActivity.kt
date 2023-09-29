package com.example.nowplaying1

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.codepath.asynchttpclient.AsyncHttpClient
import com.codepath.asynchttpclient.callback.JsonHttpResponseHandler
import okhttp3.Headers
//private const val API_KEY = "a07e22bc18f5cb106bfe4cc1f83ad8ed"
private const val TAG = "MainActivity"
private const val API_URL = "https://api.themoviedb.org/3/movie/now_playing?api_key=a07e22bc18f5cb106bfe4cc1f83ad8ed"
class MainActivity : AppCompatActivity() {

    private val movies = mutableListOf<Movie>()
    private lateinit var moviesRecyclerView : RecyclerView

    override fun onCreate(savedInstanceState: Bundle?) {

        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val movieAdapter = MovieAdapter(this, movies)
        moviesRecyclerView = findViewById(R.id.moviesRv)
        moviesRecyclerView.adapter = movieAdapter
        moviesRecyclerView.layoutManager = LinearLayoutManager(this)


        val client = AsyncHttpClient()
        client.get(API_URL, object : JsonHttpResponseHandler() {
            override fun onFailure(statusCode: Int, headers: Headers?, response: String?, throwable: Throwable?
            ) {
                Log.e(TAG, "Failure $statusCode")
            }

            override fun onSuccess(statusCode: Int, headers: Headers?, json: JSON) {
                Log.i(TAG,"JSON data retrieved $json")
                val moviesJson = json.jsonObject.getJSONArray("results")
                movies.addAll(Movie.fromJson(moviesJson))
                movieAdapter.notifyDataSetChanged()
            }
        })
    }
}