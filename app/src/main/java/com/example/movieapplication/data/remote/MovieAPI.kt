package com.example.movieapplication.data.remote

import com.example.movieapplication.data.remote.dto.MoviesDetailDto
import com.example.movieapplication.data.remote.dto.MoviesDto
import com.example.movieapplication.util.Constants.API_KEY
import retrofit2.http.GET
import retrofit2.http.Query

interface MovieAPI {


    //https://www.omdbapi.com/?s=batman&apikey=771adbe3
    //https://www.omdbapi.com/?i=tt0372784&apikey=771adbe3

    @GET(".")
    suspend fun getMovies(@Query("s") searchString : String,
                          @Query("apikey") apiKey:String=API_KEY):MoviesDto

    @GET(".")
    suspend fun getMoviesDetail(
        @Query("i") imdbId : String,
        @Query("apikey") apiKey:String=API_KEY
    ):MoviesDetailDto
}