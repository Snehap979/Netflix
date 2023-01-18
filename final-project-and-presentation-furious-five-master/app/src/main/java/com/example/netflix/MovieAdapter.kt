package com.example.netflix

import android.content.Context
import android.content.Intent
import android.media.Image
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.EditText
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide


import com.example.netflix.models.Movie
import com.example.netflix.models.MovieResponse
import com.example.netflix.R

import com.example.netflix.detailedActivity
import kotlinx.android.synthetic.main.movie_item.view.*


class MovieAdapter (
    
    private val movies : List<Movie>

        ): RecyclerView.Adapter<MovieAdapter.MovieViewHolder>(){


            class MovieViewHolder(view : View) : RecyclerView.ViewHolder(view){
                private  val IMAGE_BASE = "https://image.tmdb.org/t/p/w500/"


                fun bindMovie(movie : Movie){

                    //itemView.movie_title.text = movie.title
                    //itemView.movie_release_date.text = movie.release
                    Glide.with(itemView).load(IMAGE_BASE + movie.poster).into(itemView.movie_poster)





                }




            }



    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MovieViewHolder {

        val items =   LayoutInflater.from(parent.context).inflate(R.layout.movie_item , parent , false)
        return MovieViewHolder(items)
    }

    override fun onBindViewHolder(holder: MovieViewHolder, position: Int) {
            val movie_position = movies[position]
            holder.bindMovie(movie_position)









    }



            override fun getItemCount(): Int  = movies.size


    private val differCallback = object : DiffUtil.ItemCallback<MovieResponse>(){
        override fun areItemsTheSame(oldItem: MovieResponse, newItem: MovieResponse): Boolean {
            TODO("Not yet implemented")
        }

        override fun areContentsTheSame(oldItem: MovieResponse, newItem: MovieResponse): Boolean {
            TODO("Not yet implemented")
        }

    }

}