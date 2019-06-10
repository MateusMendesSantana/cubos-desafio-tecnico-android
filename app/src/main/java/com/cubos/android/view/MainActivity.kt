package com.cubos.android.view

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.support.design.widget.TabLayout
import android.support.v7.widget.GridLayoutManager
import android.support.v7.widget.SearchView
import kotlinx.android.synthetic.main.activity_main.*
import android.view.Menu
import android.view.inputmethod.EditorInfo
import com.cubos.android.model.Movie
import com.cubos.android.presenter.MoviePresenter
import com.cubos.android.presenter.MoviePresenterInterface
import com.cubos.android.R

class MainActivity : AppCompatActivity(), MainActivityInterface{

    lateinit var presenter: MoviePresenterInterface
    lateinit var movieAdapter: MovieAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val gridLayoutManager = GridLayoutManager(applicationContext, 2)
        recyclerView.layoutManager = gridLayoutManager

        supportActionBar?.elevation = 0f

        movieAdapter = MovieAdapter(this, ArrayList())
        recyclerView.adapter = movieAdapter

        presenter = MoviePresenter(this)
        presenter.loadMovies()

        tab_layout.addOnTabSelectedListener(object: TabLayout.OnTabSelectedListener {
            override fun onTabUnselected(p0: TabLayout.Tab?) {
            }

            override fun onTabReselected(tab: TabLayout.Tab) {
            }

            override fun onTabSelected(tab: TabLayout.Tab) {
                var genre = 28

                when(tab.position) {
                    0 -> genre = 28
                    1 -> genre = 18
                    2 -> genre = 14
                    3 -> genre = 878
                }

                movieAdapter.setCurrentGenre(genre)
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
                presenter.searchMovies(query)
                return false
            }

            override fun onQueryTextChange(newText: String): Boolean {
                presenter.searchMovies(newText)
                return false
            }
        })

        return true
    }

    override fun displayMovies(movies: ArrayList<Movie>) {
        movieAdapter.refreshMovies(movies)
    }
}
