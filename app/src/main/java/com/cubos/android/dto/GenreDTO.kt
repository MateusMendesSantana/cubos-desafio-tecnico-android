package com.cubos.android.dto

import com.cubos.android.model.Genre
import com.google.gson.annotations.SerializedName

data class GenreDTO(@SerializedName("genres") val genres: List<Genre>)