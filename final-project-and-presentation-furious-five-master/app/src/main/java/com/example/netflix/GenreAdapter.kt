package com.example.netflix

import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.netflix.models.Genre

import com.example.netflix.R

import kotlinx.android.synthetic.main.genre.view.*

class GenreAdapter(
    private val genres : List<Genre>

): RecyclerView.Adapter<GenreAdapter.GenreViewHolder>() {
    class GenreViewHolder(view : View) : RecyclerView.ViewHolder(view){

        fun bindGenre(genre : Genre){

            Log.v(TAG,"Reached Here in the Genre adapter :$genre")



            itemView.genre_id.text = genre.id
            itemView.genre_name.text = genre.name


        }


    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): GenreViewHolder {
        return GenreViewHolder(
            LayoutInflater.from(parent.context).inflate(R.layout.genre  , parent , false)
        )
    }

    override fun onBindViewHolder(holder: GenreViewHolder, position: Int) {
        holder.bindGenre(genres.get(position))
    }

    override fun getItemCount(): Int {
        val genre_size = genres.size
        Log.v(TAG,"Reached Here in the Genre adapter :$genre_size")
        return genre_size
    }

    companion object {
        private const val TAG = "Research"
    }

}