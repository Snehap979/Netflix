package com.example.netflix

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.netflix.models.Movie
import com.example.netflix.R

import kotlinx.android.synthetic.main.upcoming_movie_item.view.*

class UpcomingMovieAdapter (
    private val UpcomingMovie : List<Movie>
    ) : RecyclerView.Adapter<UpcomingMovieAdapter.UpcomingMovieViewHolder>(){
    class UpcomingMovieViewHolder(view : View) : RecyclerView.ViewHolder(view) {
        private val IMAGE_BASE = "https://image.tmdb.org/t/p/w500/"

        fun bindUpcomingMovie(movie: Movie) {

            Glide.with(itemView).load(IMAGE_BASE + movie.poster).into(itemView.movie_poster_2)
        }
    }



    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): UpcomingMovieViewHolder {
        return UpcomingMovieAdapter.UpcomingMovieViewHolder(
            LayoutInflater.from(parent.context).inflate(R.layout.upcoming_movie_item, parent, false)
        )
    }

    override fun onBindViewHolder(holder: UpcomingMovieViewHolder, position: Int) {
        holder.bindUpcomingMovie(UpcomingMovie.get(position))
    }

    override fun getItemCount(): Int = UpcomingMovie.size


}