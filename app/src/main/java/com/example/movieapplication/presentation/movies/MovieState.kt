package com.example.movieapplication.presentation.movies

import com.example.movieapplication.domain.model.Movie

data class MovieState (
    val isLoading:Boolean=false,
    val movies:List<Movie> = emptyList(),
    val error:String="",
    val search : String="batman"
)