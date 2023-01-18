package com.example.netflix

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.netflix.models.People
import kotlinx.android.synthetic.main.people_item.view.*

class PeopleAdapter (

    private val peoples : List<People>
        ): RecyclerView.Adapter<PeopleAdapter.PeopleViewHolder>(){
    class PeopleViewHolder(view : View) : RecyclerView.ViewHolder(view) {
        private  val IMAGE_BASE = "https://image.tmdb.org/t/p/w500/"

        fun bindPeople(people : People){

            Glide.with(itemView).load(IMAGE_BASE + people.profile).into(itemView.people_poster)
        }

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): PeopleViewHolder {

        val items = LayoutInflater.from(parent.context).inflate(R.layout.people_item , parent , false)
        return PeopleViewHolder(items)
    }

    override fun onBindViewHolder(holder: PeopleViewHolder, position: Int) {
        val people_position  = peoples[position]
        holder.bindPeople(people_position)
    }

    override fun getItemCount(): Int  = peoples.size


}