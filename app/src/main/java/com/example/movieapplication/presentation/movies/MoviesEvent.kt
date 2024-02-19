package com.example.movieapplication.presentation.movies

sealed class MoviesEvent {
    data class Search(val searchString : String) : MoviesEvent()
}