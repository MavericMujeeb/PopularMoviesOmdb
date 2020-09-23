package com.example.popularmoviesomdb

import android.os.Bundle
import android.view.View
import android.view.animation.OvershootInterpolator
import android.widget.Button
import android.widget.ImageView
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import androidx.cardview.widget.CardView
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import androidx.recyclerview.widget.DefaultItemAnimator
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import at.blogc.android.views.ExpandableTextView
import com.squareup.picasso.Picasso
import java.util.*

class MovieDetails : AppCompatActivity() {
    var title: TextView? = null
    var duration: TextView? = null
    var rating: TextView? = null
    var date: TextView? = null
    var director: TextView? = null
    var writer: TextView? = null
    var actor: TextView? = null
    var synopsisTextView: ExpandableTextView? = null
    var buttonToggle: Button? = null
    var imageView: ImageView? = null
    var cardView: CardView? = null
    var cardViewCast: CardView? = null
    var recyclerViewReview: RecyclerView? = null
    var rAdapter: RatingsAdapter? = null
    var ratingsList: List<Ratings> = ArrayList()
    var movieDetailsViewModel: MovieDetailsViewModel? = null
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.movie_details)
        movieDetailsViewModel = ViewModelProviders.of(this).get(
            MovieDetailsViewModel::class.java
        )
        movieDetailsViewModel!!.init()
        buttonToggle = findViewById<View>(R.id.button_toggle) as Button
        synopsisTextView = findViewById<View>(R.id.synopsis) as ExpandableTextView
        title = findViewById<View>(R.id.tv_title) as TextView
        duration = findViewById<View>(R.id.tv_runtime) as TextView
        rating = findViewById<View>(R.id.rating) as TextView
        date = findViewById<View>(R.id.releaseDate) as TextView
        director = findViewById<View>(R.id.tv_director) as TextView
        writer = findViewById<View>(R.id.tv_writer) as TextView
        actor = findViewById<View>(R.id.tv_actor) as TextView
        imageView =
            findViewById<View>(R.id.grid_item_image) as ImageView
        cardView = findViewById<View>(R.id.card_view) as CardView
        cardViewCast = findViewById<View>(R.id.card_view_cast) as CardView
        recyclerViewReview = findViewById<View>(R.id.rv_reviews) as RecyclerView
        rAdapter = RatingsAdapter(ratingsList)
        val mLayoutManager: RecyclerView.LayoutManager =
            LinearLayoutManager(applicationContext, LinearLayoutManager.HORIZONTAL, false)
        recyclerViewReview!!.layoutManager = mLayoutManager
        recyclerViewReview!!.itemAnimator = DefaultItemAnimator()
        recyclerViewReview!!.adapter = rAdapter
        cardView!!.radius = 30f
        cardView!!.cardElevation = 10f
        cardViewCast!!.radius = 30f
        cardViewCast!!.cardElevation = 10f
        synopsisTextView!!.setAnimationDuration(750L)
        synopsisTextView!!.setInterpolator(OvershootInterpolator())
        synopsisTextView!!.expandInterpolator = OvershootInterpolator()
        synopsisTextView!!.collapseInterpolator = OvershootInterpolator()
        buttonToggle!!.setOnClickListener {
            buttonToggle!!.text = if (synopsisTextView!!.isExpanded) "Read more" else "Read less"
            synopsisTextView!!.toggle()
        }
        makeAPICall(intent.getStringExtra("imdbId"))
    }

    fun makeAPICall(imdbId: String?) {
        movieDetailsViewModel!!.getMoviesDetailsRepository(imdbId)?.observe(
            this,
            Observer { movieDetails: MovieDetailsResponse ->
                if (movieDetails.poster != null) {
                    Picasso.with(imageView!!.context).load(movieDetails.poster)
                        .into(imageView)
                }
                title!!.text = movieDetails.title
                duration!!.text = movieDetails.duration
                rating!!.text = movieDetails.rating
                date!!.text = movieDetails.date
                synopsisTextView!!.text = movieDetails.plot
                ratingsList = movieDetails.ratings!!
                director!!.text = movieDetails.director
                actor!!.text = movieDetails.actors
                writer!!.text = movieDetails.writer
                recyclerViewReview!!.adapter = RatingsAdapter(ratingsList)
            } as Observer<in MovieDetailsResponse?>
        )
    }
}