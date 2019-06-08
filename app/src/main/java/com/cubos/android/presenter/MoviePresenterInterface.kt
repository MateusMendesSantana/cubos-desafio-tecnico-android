package com.cubos.android.presenter

import com.cubos.android.model.Movie

interface MoviePresenterInterface {
    fun loadMovies(): ArrayList<Movie>
}