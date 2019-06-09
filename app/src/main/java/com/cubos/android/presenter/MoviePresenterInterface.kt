package com.cubos.android.presenter

import com.cubos.android.dto.MovieDTO
import retrofit2.Call

interface MoviePresenterInterface {
    fun loadMovies()
}