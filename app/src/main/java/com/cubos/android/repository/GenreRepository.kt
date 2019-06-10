package com.cubos.android.repository

import com.cubos.android.API_KEY
import com.cubos.android.BASE_URL
import com.cubos.android.LANGUAGE
import com.cubos.android.dto.GenreDTO
import retrofit2.Call
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class GenreRepository: GenreRepositoryInterface {
    private val service : GenreRepositoryInterface

    init {
        val retrofit = Retrofit.Builder()
                .baseUrl(BASE_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .build()

        service = retrofit.create(GenreRepositoryInterface::class.java)
    }

    override fun getGenreList(apiKey: String, language: String): Call<GenreDTO> {
        return service.getGenreList(API_KEY, LANGUAGE)
    }
}