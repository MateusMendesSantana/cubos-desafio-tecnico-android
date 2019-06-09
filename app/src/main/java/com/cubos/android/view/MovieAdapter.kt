package com.cubos.android.view

import android.content.Context
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Filter
import android.widget.ImageView
import android.widget.TextView
import com.cubos.android.R
import com.cubos.android.model.Movie

class MovieAdapter(
        var context: Context,
        var movieList: MutableList<Movie>): RecyclerView.Adapter<MovieAdapter.MovieViewHolder>() {
    var movieListFull: List<Movie> = ArrayList(movieList)

    inner class MovieViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        var imageView: ImageView = itemView.findViewById(R.id.image_movie)
        var textView1: TextView = itemView.findViewById(R.id.text_movie)
    }

    fun refreshMovies(movies: MutableList<Movie>) {
        movieList = movies
        movieListFull = ArrayList(movieList)
        notifyDataSetChanged()
    }


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MovieViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(
                R.layout.movie_item,
            parent, false
        )

        return MovieViewHolder(view)
    }

    override fun onBindViewHolder(holder: MovieViewHolder, position: Int) {
        val currentMovie = movieList[position]

        currentMovie.loadImage(context, holder.imageView)
        holder.textView1.text = currentMovie.title
    }

    override fun getItemCount(): Int {
        return movieList.size
    }

    fun getFilter(): Filter {
        return exampleFilter
    }

    private val exampleFilter = object : Filter() {
        override fun performFiltering(constraint: CharSequence?): FilterResults {
            val filteredList = ArrayList<Movie>()

            if (constraint == null || constraint.isEmpty()) {
                filteredList.addAll(movieListFull)
            } else {
                val filterPattern = constraint.toString().toLowerCase().trim { it <= ' ' }

                for (item in movieListFull) {
                    if (item.title.toLowerCase().contains(filterPattern)) {
                        filteredList.add(item)
                    }
                }
            }

            val results = FilterResults()
            results.values = filteredList

            return results
        }

        override fun publishResults(constraint: CharSequence, results: FilterResults) {
            movieList.clear()
            movieList.addAll(results.values as List<Movie>)
            notifyDataSetChanged()
        }
    }
}