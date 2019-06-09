package com.cubos.android.presenter

import com.cubos.android.dto.MovieDTO
import com.cubos.android.repository.MovieRepository
import com.cubos.android.view.MainActivityInterface
import retrofit2.Call

class MoviePresenter(private val view: MainActivityInterface): MoviePresenterInterface{
    private val movieRepository = MovieRepository()

    override fun loadMovies(): Call<MovieDTO> {
        return movieRepository.getPopularList()
    }
}