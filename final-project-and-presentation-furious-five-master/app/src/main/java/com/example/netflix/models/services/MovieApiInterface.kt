package com.example.netflix.models.services

import com.example.netflix.models.*
import retrofit2.Call
import retrofit2.http.GET

interface MovieApiInterface {

    @GET("/3/movie/popular?api_key=24b5017c326236037ed33d04b26ebfcb")
    fun getMovieList() : Call<MovieResponse>

    @GET("/3/movie/top_rated?api_key=24b5017c326236037ed33d04b26ebfcb")
    fun getTopRatedMovieList() : Call<TopRatedMovieResponse>

    @GET("/3/movie/upcoming?api_key=24b5017c326236037ed33d04b26ebfcb&language=en-US&page=1")
    fun getUpcomingMovieList() : Call<UpcomingMovieResponse>

    @GET("/3/genre/movie/list?api_key=24b5017c326236037ed33d04b26ebfcb")
    fun getGenresList() : Call<GenreResponse>

    @GET("/3/genre/movie/list?api_key=24b5017c326236037ed33d04b26ebfcb")
    fun getTrendingList() : Call<TrendingResponse>

    @GET("/3/person/popular?api_key=24b5017c326236037ed33d04b26ebfcb")
    fun getPersonList() : Call<PeopleResponse>
}