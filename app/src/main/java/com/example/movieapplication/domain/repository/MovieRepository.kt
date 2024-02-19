package com.example.movieapplication.domain.repository

import com.example.movieapplication.data.remote.dto.MoviesDetailDto
import com.example.movieapplication.data.remote.dto.MoviesDto

interface MovieRepository {

    suspend fun getMovies(search:String) :MoviesDto
    suspend fun getMoviesDetail(imdbId:String) : MoviesDetailDto
}