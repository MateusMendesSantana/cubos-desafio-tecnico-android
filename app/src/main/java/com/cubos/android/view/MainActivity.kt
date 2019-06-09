package com.cubos.android.view

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.support.v7.widget.GridLayoutManager
import android.support.v7.widget.SearchView
import kotlinx.android.synthetic.main.activity_main.*
import android.view.Menu
import android.view.inputmethod.EditorInfo
import com.cubos.android.model.Movie
import com.cubos.android.presenter.MoviePresenter
import com.cubos.android.presenter.MoviePresenterInterface
import android.util.Log
import com.cubos.android.R
import com.cubos.android.dto.MovieDTO
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response


class MainActivity : AppCompatActivity(), MainActivityInterface{

    lateinit var presenter: MoviePresenterInterface
    lateinit var movieAdapter: MovieAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val gridLayoutManager = GridLayoutManager(applicationContext, 2)
        recyclerView.layoutManager = gridLayoutManager

        presenter = MoviePresenter(this)

        val call = presenter.loadMovies()
        call.enqueue(object : Callback<MovieDTO> {
            override fun onFailure(call: Call<MovieDTO>, t: Throwable) {
                Log.i("Error ONE Movie: ", t.message)
            }

            override fun onResponse(call: Call<MovieDTO>, response: Response<MovieDTO>) {
                val movieDTO = response.body()

                if (movieDTO != null) {
                    movieAdapter = MovieAdapter(ArrayList(movieDTO.movies))
                    recyclerView.adapter = movieAdapter
                }
            }
        })
    }

    override fun onCreateOptionsMenu(menu: Menu): Boolean {
        menuInflater.inflate(R.menu.toolbar_menu, menu)

        val searchItem = menu.findItem(R.id.action_search)
        val searchView = searchItem.actionView as SearchView

        searchView.imeOptions = EditorInfo.IME_ACTION_DONE

        searchView.setOnQueryTextListener(object : SearchView.OnQueryTextListener {
            override fun onQueryTextSubmit(query: String): Boolean {
                return false
            }

            override fun onQueryTextChange(newText: String): Boolean {
                movieAdapter.getFilter().filter(newText)
                return false
            }
        })
        return true
    }

    override fun displayMovies(movies: ArrayList<Movie>) {
        movieAdapter.refreshMovies(movies)
    }
}
