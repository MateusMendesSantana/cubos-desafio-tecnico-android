package com.cubos.android.view

import com.cubos.android.model.Movie
import kotlin.collections.ArrayList

interface MainActivityInterface {
    fun displayMovies(movies: ArrayList<Movie>)
}