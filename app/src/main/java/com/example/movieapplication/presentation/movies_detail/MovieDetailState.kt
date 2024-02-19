package com.example.movieapplication.presentation.movies_detail

import com.example.movieapplication.domain.model.MoviesDetail

data class MovieDetailState(
    var isLoading:Boolean=false,
    val moviesDetail: MoviesDetail?=null,
    val error:String=""
)