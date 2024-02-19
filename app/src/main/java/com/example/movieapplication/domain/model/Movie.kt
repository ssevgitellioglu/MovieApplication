package com.example.movieapplication.domain.model

import com.example.movieapplication.data.remote.dto.MoviesDto

data class Movie(
    val Poster: String,
    val Title: String,
    val Year: String,
    val imdbID: String
)
