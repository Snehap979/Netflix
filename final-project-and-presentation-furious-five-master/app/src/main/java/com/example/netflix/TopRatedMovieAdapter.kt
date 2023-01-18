package com.example.netflix
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.netflix.TopRatedMovieAdapter.TopRatedMovieViewHolder
import com.example.netflix.models.Movie
import com.example.netflix.R

import kotlinx.android.synthetic.main.movie_item.view.*
import kotlinx.android.synthetic.main.top_movie_item.view.*

class TopRatedMovieAdapter (
    private val TopRatedMovies : List<Movie>
        ) : RecyclerView.Adapter<TopRatedMovieAdapter.TopRatedMovieViewHolder>(){
    class TopRatedMovieViewHolder(view : View) : RecyclerView.ViewHolder(view) {
        private  val IMAGE_BASE = "https://image.tmdb.org/t/p/w500/"
        fun bindTopMovie(movie : Movie){




            //itemView.movie_title.text = movie.title
            //itemView.movie_release_date.text = movie.release
            Glide.with(itemView).load(IMAGE_BASE + movie.poster).into(itemView.movie_poster_1)

        }
    }



    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): TopRatedMovieViewHolder {
        return TopRatedMovieViewHolder(
            LayoutInflater.from(parent.context).inflate(R.layout.top_movie_item, parent, false)
        )
    }

    override fun onBindViewHolder(holder: TopRatedMovieViewHolder, position: Int) {
        holder.bindTopMovie(TopRatedMovies.get(position))
    }

    override fun getItemCount(): Int = TopRatedMovies.size
}