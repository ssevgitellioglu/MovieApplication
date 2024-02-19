package com.example.movieapplication.data.remote.dto

import com.example.movieapplication.domain.model.Movie
import com.example.movieapplication.domain.model.MoviesDetail

data class MoviesDetailDto(
    val Actors: String,
    val Awards: String,
    val Country: String,
    val Director: String,
    val Genre: String,
    val Language: String,
    val Poster: String,
    val Production: String,
    val Rated: String,
    val Released: String,
    val Title: String,
    val Type: String,
    val Website: String,
    val Year: String,
    val imdbRating: String,
)

fun MoviesDetailDto.toMovieDetail(): MoviesDetail {
return MoviesDetail(Actors, Awards, Country, Director, Genre, Language, Poster, Production, Rated, Released, Title, Type, Website, Year, imdbRating)
}