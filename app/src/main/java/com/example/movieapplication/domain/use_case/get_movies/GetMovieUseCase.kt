package com.example.movieapplication.domain.use_case.get_movies

import com.example.movieapplication.data.remote.dto.toMovieList
import com.example.movieapplication.domain.model.Movie
import com.example.movieapplication.domain.repository.MovieRepository
import com.example.movieapplication.util.Resource
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import java.io.IOError
import javax.inject.Inject

class GetMovieUseCase @Inject constructor(private val repository: MovieRepository) {
    fun executeGetMovies(search:String):Flow<Resource<List<Movie>>> = flow {
        try {
            emit(Resource.Loading())
            val movieList= repository.getMovies(search)
            if(movieList.Response == "True"){
                emit(Resource.Success(movieList.toMovieList()))
            }
            else{
                emit(Resource.Error(message = "No movie found !"))
            }
        }
        catch (e : IOError){
            emit(Resource.Error(message =e.localizedMessage ?: "Error" ))

        }
    }

}
