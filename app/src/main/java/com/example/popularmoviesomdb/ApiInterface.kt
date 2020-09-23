package com.example.popularmoviesomdb

import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Query

interface ApiInterface {
    @GET(".")
    fun getTopRatedMovies(
        @Query("apikey") apiKey: String?,
        @Query("s") s: String?,
        @Query("type") type: String?
    ): Call<MoviesResponse?>?

    @GET(".")
    fun getMovieDetails(
        @Query("apikey") apiKey: String?,
        @Query("i") i: String?
    ): Call<MovieDetailsResponse?>?
}