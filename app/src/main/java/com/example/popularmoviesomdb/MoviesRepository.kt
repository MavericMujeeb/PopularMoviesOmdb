package com.example.popularmoviesomdb

import androidx.lifecycle.MutableLiveData
import com.example.popularmoviesomdb.ApiClient.client
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class MoviesRepository {
    var apiService = client!!.create(ApiInterface::class.java)
    fun getMoviesList(movieName: String?): MutableLiveData<List<Movie>?> {
        val moviesList =
            MutableLiveData<List<Movie>?>()
        val call =
            apiService.getTopRatedMovies(API_KEY, movieName, "movie")
        call?.enqueue(object : Callback<MoviesResponse?> {
            override fun onResponse(
                call: Call<MoviesResponse?>,
                response: Response<MoviesResponse?>
            ) {
                val movies =
                    response.body()?.results
                moviesList.setValue(movies)
            }

            override fun onFailure(
                call: Call<MoviesResponse?>,
                t: Throwable
            ) {
                // Log error here since request failed
                moviesList.setValue(null)
            }
        })
        return moviesList
    }

    fun getMovieDetails(imdbId: String?): MutableLiveData<MovieDetailsResponse?> {
        val movieDetails =
            MutableLiveData<MovieDetailsResponse?>()
        val call =
            apiService.getMovieDetails(API_KEY, imdbId)
        call!!.enqueue(object : Callback<MovieDetailsResponse?> {
            override fun onResponse(
                call: Call<MovieDetailsResponse?>,
                response: Response<MovieDetailsResponse?>
            ) {
                val movieDetailsResponse = response.body()
                movieDetails.setValue(movieDetailsResponse)
            }

            override fun onFailure(
                call: Call<MovieDetailsResponse?>,
                t: Throwable
            ) {
                // Log error here since request failed
                movieDetails.setValue(null)
            }
        })
        return movieDetails
    }

    companion object {
        // TODO - insert your themoviedb.org API KEY here
        private val API_KEY: String = "b9bd48a6";
        private var moviesRepository: MoviesRepository? = null
        val instance: MoviesRepository?
            get() {
                if (moviesRepository == null) {
                    moviesRepository = MoviesRepository()
                }
                return moviesRepository
            }
    }
}