package com.example.movieapplication.domain.repository

import com.example.movieapplication.data.remote.MovieAPI
import com.example.movieapplication.data.remote.dto.MoviesDetailDto
import com.example.movieapplication.data.remote.dto.MoviesDto
import javax.inject.Inject

class MovieRepositoryImpl @Inject constructor(private val api:MovieAPI) : MovieRepository{
    override suspend fun getMovies(search: String): MoviesDto {
        return api.getMovies(searchString = search)
    }

    override suspend fun getMoviesDetail(imdbId: String): MoviesDetailDto {
        return  api.getMoviesDetail(imdbId=imdbId)

    }
}