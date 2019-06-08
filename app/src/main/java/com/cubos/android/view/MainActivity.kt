package com.cubos.android.view

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.support.v7.widget.GridLayoutManager
import android.support.v7.widget.SearchView
import kotlinx.android.synthetic.main.activity_main.*
import android.view.Menu
import android.view.inputmethod.EditorInfo
import com.cubos.android.R
import com.cubos.android.model.Movie

class MainActivity : AppCompatActivity() {
    lateinit var movieAdapter: MovieAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val gridLayoutManager = GridLayoutManager(applicationContext, 2)
        recyclerView.layoutManager = gridLayoutManager

        val myDataset = ArrayList<Movie>()
        myDataset.add(Movie("Vingadores: Ultimato", ""))
        myDataset.add(Movie("Godzilla II: Rei dos Monstros", ""))
        myDataset.add(Movie("Power Rangers", ""))
        myDataset.add(Movie("A", ""))
        myDataset.add(Movie("A", ""))
        movieAdapter = MovieAdapter(myDataset)
        recyclerView.adapter = movieAdapter
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
}
