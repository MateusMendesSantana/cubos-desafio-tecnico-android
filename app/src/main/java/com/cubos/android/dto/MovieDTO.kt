package com.cubos.android.dto

import com.cubos.android.model.Movie
import com.google.gson.annotations.SerializedName

data class MovieDTO(@SerializedName("results") val movies: List<Movie>)