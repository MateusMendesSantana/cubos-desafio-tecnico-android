package com.cubos.android.presenter

import com.cubos.android.model.Movie
import com.cubos.android.repository.MovieRepository
import com.cubos.android.view.MainActivityInterface

class MoviePresenter(private val view: MainActivityInterface): MoviePresenterInterface{
    private val movieRepository = MovieRepository()

    override fun loadMovies(): ArrayList<Movie> {
        return movieRepository.loadMovies()
    }
}