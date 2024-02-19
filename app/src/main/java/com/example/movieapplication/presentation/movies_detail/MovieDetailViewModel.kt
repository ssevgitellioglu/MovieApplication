package com.example.movieapplication.presentation.movies_detail

import android.view.View
import androidx.compose.runtime.State
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.SavedStateHandle
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.movieapplication.domain.model.Movie
import com.example.movieapplication.domain.use_case.get_movies_detail.GetMovieDetailUseCase
import com.example.movieapplication.util.Constants.IMDB_ID
import com.example.movieapplication.util.Resource
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.launchIn
import kotlinx.coroutines.flow.onEach
import javax.inject.Inject

@HiltViewModel
class MovieDetailViewModel @Inject constructor(
    private val getMovieDetailUseCase: GetMovieDetailUseCase,
    private val stateHandle:SavedStateHandle
): ViewModel() {
    private val _state= mutableStateOf<MovieDetailState>(MovieDetailState())
    val state:State<MovieDetailState> = _state

    init {
        stateHandle.get<String>(IMDB_ID)?.let {
            getMovieDetail(it)
}
    }
    private fun getMovieDetail(imdbId: String) {
        getMovieDetailUseCase.executeGetMovieDetail(imdbId = imdbId).onEach {
            when (it) {
                is Resource.Success -> {
                    _state.value = MovieDetailState(moviesDetail = it.data)
                }

                is Resource.Error -> {
                    _state.value = MovieDetailState(error = it.message ?: "Error!")

                }

                is Resource.Loading -> {
                    _state.value = MovieDetailState(isLoading = true)
                }
            }
        }.launchIn(viewModelScope)
    }
}