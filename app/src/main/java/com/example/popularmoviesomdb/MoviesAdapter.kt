package com.example.popularmoviesomdb

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.LinearLayout
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import androidx.recyclerview.widget.RecyclerView.ViewHolder
import com.example.popularmoviesomdb.MoviesAdapter.MovieViewHolder
import com.squareup.picasso.Picasso

class MoviesAdapter(
    private val movies: List<Movie>,
    private val rowLayout: Int,
    private val context: Context
) : RecyclerView.Adapter<MovieViewHolder>() {

    class MovieViewHolder(v: View) : ViewHolder(v) {
        var moviesLayout: LinearLayout
        var movieTitle: TextView
        var rating: TextView
        var imageView: ImageView

        init {
            moviesLayout = v.findViewById<View>(R.id.movies_layout) as LinearLayout
            movieTitle = v.findViewById<View>(R.id.detail_title) as TextView
            rating = v.findViewById<View>(R.id.release_year) as TextView
            imageView =
                v.findViewById<View>(R.id.grid_item_image) as ImageView
        }
    }

    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): MovieViewHolder {
        val view =
            LayoutInflater.from(parent.context).inflate(rowLayout, parent, false)
        return MovieViewHolder(view)
    }

    override fun onBindViewHolder(holder: MovieViewHolder, position: Int) {
        holder.movieTitle.text = movies[position].title
        holder.rating.text = movies[position].year
        Picasso.with(context).load(movies[position].poster).into(holder.imageView)
    }

    override fun getItemCount(): Int {
        return movies.size
    }

}