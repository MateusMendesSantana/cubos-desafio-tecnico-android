package com.cubos.android.presenter

import android.util.Log
import com.cubos.android.dto.MovieDTO
import com.cubos.android.repository.MovieRepository
import com.cubos.android.view.MainActivityInterface
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class MoviePresenter(private val view: MainActivityInterface): MoviePresenterInterface{
    private val movieRepository = MovieRepository()

    override fun loadMovies() {

        val call = movieRepository.getPopularList()
        call.enqueue(object : Callback<MovieDTO> {
            override fun onFailure(call: Call<MovieDTO>, t: Throwable) {
                Log.i("Error ONE Movie: ", t.message)
            }

            override fun onResponse(call: Call<MovieDTO>, response: Response<MovieDTO>) {
                val movieDTO = response.body()

                if (movieDTO != null) {
                    view.displayMovies(ArrayList(movieDTO.movies))
                }
            }
        })
    }

    override fun searchMovies(query: String) {
        val call = movieRepository.searchMovie(query)

        call.enqueue(object : Callback<MovieDTO> {
            override fun onFailure(call: Call<MovieDTO>, t: Throwable) {
                Log.i("Error ONE Movie: ", t.message)
            }

            override fun onResponse(call: Call<MovieDTO>, response: Response<MovieDTO>) {
                val movieDTO = response.body()

                if (movieDTO != null) {
                    view.displayMovies(ArrayList(movieDTO.movies))
                }
            }
        })
    }
}