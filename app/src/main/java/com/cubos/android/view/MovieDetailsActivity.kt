package com.cubos.android.view

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import com.cubos.android.R
import com.cubos.android.model.Movie
import kotlinx.android.synthetic.main.activity_movie_details.*

class MovieDetailsActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_movie_details)

        supportActionBar?.setDisplayHomeAsUpEnabled(true)

        val movie = intent.getSerializableExtra("Movie") as Movie

        setDetails(movie)
    }

    private fun setDetails(movie: Movie) {
        text_description.text = movie.overview
        movie.loadImage(this, image_post)
        supportActionBar?.title = movie.title
    }

    override fun onSupportNavigateUp(): Boolean {
        finish()

        return true
    }
}
