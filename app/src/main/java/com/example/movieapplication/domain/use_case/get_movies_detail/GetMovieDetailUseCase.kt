package com.example.movieapplication.domain.use_case.get_movies_detail

import com.example.movieapplication.data.remote.dto.toMovieDetail
import com.example.movieapplication.domain.model.MoviesDetail
import com.example.movieapplication.domain.repository.MovieRepository
import com.example.movieapplication.util.Resource
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import java.io.IOError
import javax.inject.Inject

class GetMovieDetailUseCase @Inject constructor(private val repository: MovieRepository) {
    fun executeGetMovieDetail(imdbId: String): Flow<Resource<MoviesDetail>> = flow {
        try {
            emit(Resource.Loading())
            val movieDetail = repository.getMoviesDetail(imdbId = imdbId)
            emit(Resource.Success(movieDetail.toMovieDetail()))
        } catch (e: IOError) {
            emit(Resource.Error(message = e.localizedMessage ?: "Error"))

        }
    }
}


