package com.cubos.android.repository

import com.cubos.android.dto.GenreDTO
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Query

interface GenreRepositoryInterface {
    @GET("genre/movie/list")
    fun getGenreList(
            @Query("api_key") apiKey: String,
            @Query("language") language: String): Call<GenreDTO>
}