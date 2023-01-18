package com.example.netflix

import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.AdapterView
import androidx.core.content.ContextCompat.startActivity
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.netflix.models.Movie
import kotlinx.android.synthetic.main.trending_movie_item.view.*



class TrendingAdapter (
    private val TrendingMovies : List<Movie>
    ): RecyclerView.Adapter<TrendingAdapter.TrendingViewHolder>(){
    class TrendingViewHolder(view : View) : RecyclerView.ViewHolder(view) {
        private val IMAGE_BASE = "https://image.tmdb.org/t/p/w500/"

        fun bindTrendingMovie(movie: Movie) {

            Glide.with(itemView).load(IMAGE_BASE + movie.poster).into(itemView.movie_poster_5)
        }
    }




    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): TrendingViewHolder {
        return TrendingAdapter.TrendingViewHolder(
            LayoutInflater.from(parent.context).inflate(R.layout.trending_movie_item , parent , false)
        )
    }

    override fun onBindViewHolder(holder: TrendingViewHolder, position: Int) {
        holder.bindTrendingMovie(TrendingMovies.get(position))

    }

    override fun getItemCount(): Int = TrendingMovies.size





}

