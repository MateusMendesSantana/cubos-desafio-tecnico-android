package com.cubos.android.repository

import com.cubos.android.model.Movie

interface MovieRepositoryInterface {
    fun loadMovies(): ArrayList<Movie>
}