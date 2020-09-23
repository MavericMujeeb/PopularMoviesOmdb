package com.example.popularmoviesomdb

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.cardview.widget.CardView
import androidx.recyclerview.widget.RecyclerView
import androidx.recyclerview.widget.RecyclerView.ViewHolder
import com.example.popularmoviesomdb.RatingsAdapter.MyViewHolder

class RatingsAdapter(private val ratingsList: List<Ratings>) :
    RecyclerView.Adapter<MyViewHolder>() {

    inner class MyViewHolder(view: View) : ViewHolder(view) {
        var source: TextView
        var value: TextView
        var cardView: CardView

        init {
            source = view.findViewById<View>(R.id.tv_source) as TextView
            value = view.findViewById<View>(R.id.tv_value) as TextView
            cardView = view.findViewById<View>(R.id.card_view_review) as CardView
            cardView.radius = 30f
            cardView.cardElevation = 10f
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {
        val itemView = LayoutInflater.from(parent.context)
            .inflate(R.layout.rv_item, parent, false)
        return MyViewHolder(itemView)
    }

    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
        val ratings = ratingsList[position]
        holder.source.text = ratings.source
        holder.value.text = ratings.value
    }

    override fun getItemCount(): Int {
        return ratingsList.size
    }

}