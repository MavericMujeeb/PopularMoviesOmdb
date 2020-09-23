package com.example.popularmoviesomdb

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class MoviesListViewModel : ViewModel() {
    private var movieListLiveData: MutableLiveData<List<Movie>?>? =
        null
    private var moviesRepository: MoviesRepository? = null
    fun init() {
        if (movieListLiveData != null) {
            return
        }
        moviesRepository = MoviesRepository.instance
    }

    fun getMoviesListRepository(moviename: String?): LiveData<List<Movie>?>? {
        movieListLiveData = moviesRepository!!.getMoviesList(moviename)
        return movieListLiveData
    }
}