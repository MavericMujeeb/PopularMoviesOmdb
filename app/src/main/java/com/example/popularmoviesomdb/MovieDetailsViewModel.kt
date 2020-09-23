package com.example.popularmoviesomdb

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class MovieDetailsViewModel : ViewModel() {
    private var movieDetailsLiveData: MutableLiveData<MovieDetailsResponse?>? = null
    private var moviesRepository: MoviesRepository? = null
    fun init() {
        if (movieDetailsLiveData != null) {
            return
        }
        moviesRepository = MoviesRepository.instance
    }

    fun getMoviesDetailsRepository(imdbId: String?): LiveData<MovieDetailsResponse?> {
        movieDetailsLiveData = moviesRepository!!.getMovieDetails(imdbId)
        return movieDetailsLiveData!!
    }
}