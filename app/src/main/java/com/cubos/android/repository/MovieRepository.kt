package com.cubos.android.repository

import com.cubos.android.dto.MovieDTO
import retrofit2.Call
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class MovieRepository: MovieRepositoryInterface {

    private val service : MovieRepositoryInterface
    private val apiKey = "05db07e27024bc56a1e3aa80f74fc6bd"
    private val language = "pt-BR"
    private val baseUrl = "https://api.themoviedb.org/3/"

    init {
        val retrofit = Retrofit.Builder()
                .baseUrl(baseUrl)
                .addConverterFactory(GsonConverterFactory.create())
                .build()

        service = retrofit.create(MovieRepositoryInterface::class.java)
    }

    override fun searchMovie(apiKey: String, query: String, language: String): Call<MovieDTO> {
        return service.searchMovie(apiKey, query, language)
    }

    override fun getPopularList(apiKey: String, language: String): Call<MovieDTO> {
        return service.getPopularList(apiKey, language)
    }

    fun getPopularList(): Call<MovieDTO> {
        return getPopularList(apiKey, language)
    }

    fun searchMovie(query: String): Call<MovieDTO> {
        return if(query.isEmpty()) {
            getPopularList()
        } else {
            searchMovie(apiKey, query, language)
        }
    }
}