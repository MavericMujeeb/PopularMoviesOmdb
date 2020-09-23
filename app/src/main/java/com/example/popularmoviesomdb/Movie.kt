package com.example.popularmoviesomdb

import com.google.gson.annotations.SerializedName

class Movie(
    @field:SerializedName("Title") var title: String,
    @field:SerializedName("Year") var year: String,
    @field:SerializedName("imdbID") var imdbID: String,
    @field:SerializedName("Poster") var poster: String
)