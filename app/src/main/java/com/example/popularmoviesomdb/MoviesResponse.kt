package com.example.popularmoviesomdb

import com.google.gson.annotations.SerializedName

class MoviesResponse {
    @SerializedName("Search")
    var results: List<Movie>? = null

}