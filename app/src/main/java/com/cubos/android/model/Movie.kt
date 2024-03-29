package com.cubos.android.model

import android.content.Context
import android.widget.ImageView
import com.bumptech.glide.Glide
import com.google.gson.annotations.SerializedName
import java.io.Serializable

class Movie(
        val id: Int,
        val video: Boolean,
        val title: String,
        val popularity: Float,
        val adult: Boolean,
        val overview: String,
        @SerializedName("vote_average")
        val voteAverage: Float,
        @SerializedName("poster_path")
        val posterPath: String,
        @SerializedName("original_language")
        val originalLanguage: String,
        @SerializedName("original_title")
        val originalTitle: String,
        @SerializedName("genre_ids")
        val genreIds: List<Int>,
        @SerializedName("backdrop_path")
        val backdropPath: String,
        @SerializedName("vote_count")
        val voteCount: String,
        @SerializedName("release_date")
        val releaseDate: String): Serializable {

    fun loadImage(context: Context, imageView: ImageView) {
        Glide.with(context).load("https://image.tmdb.org/t/p/w500$posterPath").into(imageView)
    }
}