package com.example.popularmoviesomdb

import com.google.gson.annotations.SerializedName

class MovieDetailsResponse {
    @SerializedName("Title")
    var title: String? = null

    @SerializedName("Runtime")
    var duration: String? = null

    @SerializedName("imdbRating")
    var rating: String? = null

    @SerializedName("Released")
    var date: String? = null

    @SerializedName("Poster")
    var poster: String? = null

    @SerializedName("Plot")
    var plot: String? = null

    @SerializedName("Director")
    var director: String? = null

    @SerializedName("Writer")
    var writer: String? = null

    @SerializedName("Actors")
    var actors: String? = null

    @SerializedName("Ratings")
    var ratings: List<Ratings>? = null

}