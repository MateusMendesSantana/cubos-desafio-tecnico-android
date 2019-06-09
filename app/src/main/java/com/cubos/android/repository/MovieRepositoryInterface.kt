package com.cubos.android.repository

import com.cubos.android.dto.MovieDTO
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Query

interface MovieRepositoryInterface {

    @GET("search/movie")
    fun searchMovie(
            @Query("api_key") apiKey: String,
            @Query("query") query: String,
            @Query("lenguage") lenguage: String?): Call<MovieDTO>

    @GET("movie/popular")
    fun getPopularList(
            @Query("api_key") apiKey: String,
            @Query("lenguage") lenguage: String?): Call<MovieDTO>
}