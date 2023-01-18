package com.example.netflix

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import androidx.recyclerview.widget.LinearLayoutManager


import com.example.netflix.models.*
import com.example.netflix.models.services.MovieApiInterface
import com.example.netflix.models.services.MovieApiService

import kotlinx.android.synthetic.main.activity_home_page.*
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class   homePageActivity : AppCompatActivity() {




    override fun onCreate(savedInstanceState: Bundle?) {



        super.onCreate(savedInstanceState)

        setContentView(R.layout.activity_home_page)
        
        //TrendingAdapter.setClickListener(onClicked)


        


        news_and_hot.setOnClickListener{
            intent = Intent(this@homePageActivity, GestureActivity::class.java)
            startActivity(intent)
        }

        Fast_laughs.setOnClickListener{
            intent=Intent(this@homePageActivity , ManageProfileActivity::class.java)
            startActivity(intent)
        }

        Downloads.setOnClickListener{
            intent=Intent(this@homePageActivity , MainActivity2::class.java)
            startActivity(intent)

        }






        rv_movies_list.layoutManager =
            LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL, false)
        rv_movies_list.setHasFixedSize(true)

        getMovieData { movies: List<Movie> ->
            rv_movies_list.adapter = MovieAdapter(movies)
        }

        rv_movies_list_2.layoutManager =
            LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL, false)
        rv_movies_list_2.setHasFixedSize(false)


        getTopRatedMovieData { TopRatedMovies: List<Movie> ->
            rv_movies_list_2.adapter = TopRatedMovieAdapter(TopRatedMovies)
        }

        rv_movies_list_3.layoutManager =
            LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL, false)
        rv_movies_list_3.setHasFixedSize(false)

        getUpcomingMovieData { UpcomingMovie: List<Movie> ->
            rv_movies_list_3.adapter = UpcomingMovieAdapter(UpcomingMovie)
                Log.v(TAG,"Reached Here: $UpcomingMovie")
                print("Reached here")
        }

//        rv_movies_list_4.layoutManager =
//            LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL, false)
//        rv_movies_list_4.setHasFixedSize(false)
//
//        getUpcomingMovieData { UpcomingMovie: List<Movie> ->
//            rv_movies_list_4.adapter = UpcomingMovieAdapter(UpcomingMovie)
//            Log.v(TAG,"Reached Here: $UpcomingMovie")
//            print("Reached here")
//        }




        rv_movies_list_4.layoutManager =
            LinearLayoutManager(this , LinearLayoutManager.HORIZONTAL , false)
        rv_movies_list_4.setHasFixedSize(false)

        getListOfTrending{  TrendingMovies : List<Movie> ->
            rv_movies_list_4.adapter = TrendingAdapter(TrendingMovies)

        }

        rv_movies_list_5.layoutManager =
            LinearLayoutManager(this , LinearLayoutManager.HORIZONTAL , false)
        rv_movies_list_5.setHasFixedSize(false)

        getListOfPeople{ peoples : List<People> ->
            rv_movies_list_5.adapter = PeopleAdapter(peoples)
        }





//        genres_list.layoutManager =
//            LinearLayoutManager(this)
//        genres_list.setHasFixedSize(true)
//        getListOfGenres() { genres: List<Genre> ->
//            genres_list.adapter = GenreAdapter(genres)
//            Log.v(Companion.TAG,"Reached Here as well: $genres")
//
//        }
    }


    private fun getUpcomingMovieData(callback: (List<Movie>) -> Unit) {
        val apiService = MovieApiService.getInstance().create((MovieApiInterface::class.java))
        apiService.getUpcomingMovieList().enqueue(object : Callback<UpcomingMovieResponse> {
            override fun onResponse(
                call: Call<UpcomingMovieResponse>,
                response: Response<UpcomingMovieResponse>
            ) {
                return callback(response.body()!!.upcomingMovie)
            }

            override fun onFailure(call: Call<UpcomingMovieResponse>, t: Throwable) {

            }

        })

    }

    private fun getMovieData(callback: (List<Movie>) -> Unit) {
        val apiService = MovieApiService.getInstance().create(MovieApiInterface::class.java)
        apiService.getMovieList().enqueue(object : Callback<MovieResponse> {
            override fun onResponse(
                call: Call<MovieResponse>,
                response: Response<MovieResponse>
            ) {
                return callback(response.body()!!.movie)
            }

            override fun onFailure(call: Call<MovieResponse>, t: Throwable) {


            }

        })

    }

    private fun getTopRatedMovieData(callback: (List<Movie>) -> Unit) {
        val apiService = MovieApiService.getInstance().create(MovieApiInterface::class.java)
        apiService.getTopRatedMovieList().enqueue(object : Callback<TopRatedMovieResponse> {
            override fun onResponse(
                call: Call<TopRatedMovieResponse>,
                response: Response<TopRatedMovieResponse>
            ) {
                return callback(response.body()!!.topRatedMovie)
            }


            override fun onFailure(call: Call<TopRatedMovieResponse>, t: Throwable) {

            }

        })

    }
    private fun getListOfTrending(callback: (List<Movie>) -> Unit)
    {
        val apiService  = MovieApiService.getInstance().create((MovieApiInterface::class.java))
        apiService.getTrendingList().enqueue(object : Callback<TrendingResponse> {
            override fun onResponse(
                call: Call<TrendingResponse>,
                response: Response<TrendingResponse>
            ) {

            }

            override fun onFailure(call: Call<TrendingResponse>, t: Throwable) {

            }

        })

    }
    private fun getListOfGenres(callback: (List<Movie>) -> Unit) {
        val apiService = MovieApiService.getInstance().create((MovieApiInterface::class.java))
        apiService.getGenresList().enqueue(object : Callback<GenreResponse>
        {
            override fun onResponse(call: Call<GenreResponse>, response: Response<GenreResponse>) {

            }

            override fun onFailure(call: Call<GenreResponse>, t: Throwable) {

            }

        }

        )

    }

    private fun getListOfPeople(callback: (List<People>) -> Unit){
        val apiService = MovieApiService.getInstance().create((MovieApiInterface::class.java))
        apiService.getPersonList().enqueue(object : Callback<PeopleResponse>
        {
            override fun onResponse(
                call: Call<PeopleResponse>,
                response: Response<PeopleResponse>
            ) {

            }

            override fun onFailure(call: Call<PeopleResponse>, t: Throwable) {

            }

        })
    }

    companion object {
        private const val TAG = "Research"
    }

//

}
