package com.cubos.android.presenter

interface MoviePresenterInterface {
    fun loadMovies()
    fun searchMovies(query: String)
}