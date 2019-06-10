package com.cubos.android.repository

import com.cubos.android.API_KEY
import com.cubos.android.BASE_URL
import com.cubos.android.LANGUAGE
import com.cubos.android.dto.MovieDTO
import retrofit2.Call
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class MovieRepository: MovieRepositoryInterface {

    private val service : MovieRepositoryInterface

    init {
        val retrofit = Retrofit.Builder()
                .baseUrl(BASE_URL)
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
        return getPopularList(API_KEY, LANGUAGE)
    }

    fun searchMovie(query: String): Call<MovieDTO> {
        return if(query.isEmpty()) {
            getPopularList()
        } else {
            searchMovie(API_KEY, query, LANGUAGE)
        }
    }
}