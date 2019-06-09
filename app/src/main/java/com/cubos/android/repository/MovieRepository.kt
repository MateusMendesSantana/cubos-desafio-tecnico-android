package com.cubos.android.repository

import com.cubos.android.dto.MovieDTO
import retrofit2.Call
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class MovieRepository: MovieRepositoryInterface {

    private val service : MovieRepositoryInterface
    private val apiKey = "05db07e27024bc56a1e3aa80f74fc6bd"
    private val lenguage = "en-US"

    init {
        val retrofit = Retrofit.Builder()
                .baseUrl("https://api.themoviedb.org/3/")
                .addConverterFactory(GsonConverterFactory.create())
                .build()

        service = retrofit.create(MovieRepositoryInterface::class.java)
    }

    override fun searchMovie(apiKey: String, query: String, lenguage: String?): Call<MovieDTO> {
        return service.searchMovie(apiKey, query, lenguage)
    }

    override fun getPopularList(apiKey: String, lenguage: String?): Call<MovieDTO> {
        return service.getPopularList(apiKey, lenguage)
    }

    fun getPopularList(): Call<MovieDTO> {
        return getPopularList(apiKey, lenguage)
    }
}