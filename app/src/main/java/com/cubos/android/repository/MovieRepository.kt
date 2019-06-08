package com.cubos.android.repository

import com.cubos.android.model.Movie

class MovieRepository: MovieRepositoryInterface {
    override fun loadMovies(): ArrayList<Movie> {
        val myDataset = ArrayList<Movie>()

        myDataset.add(Movie("Vingadores: Ultimato", ""))
        myDataset.add(Movie("Godzilla II: Rei dos Monstros", ""))
        myDataset.add(Movie("Power Rangers", ""))
        myDataset.add(Movie("A", ""))
        myDataset.add(Movie("A", ""))

        return myDataset
    }
}