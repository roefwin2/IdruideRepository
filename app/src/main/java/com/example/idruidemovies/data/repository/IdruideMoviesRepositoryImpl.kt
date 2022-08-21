package com.example.idruidemovies.data.repository

import com.example.idruidemovies.data.remote.api.IdruideMoviesApi
import com.example.idruidemovies.data.remote.models.TMDBMovie.Companion.toIdruideMovieList
import com.example.idruidemovies.domain.models.IdruideMovie
import com.example.idruidemovies.domain.repository.IdruideMoviesRepository
import com.example.idruidemovies.utils.Error
import com.example.idruidemovies.utils.Loading
import com.example.idruidemovies.utils.Success
import kotlinx.coroutines.flow.flow
import javax.inject.Inject

class IdruideMoviesRepositoryImpl@Inject constructor(
    private val api: IdruideMoviesApi
) : IdruideMoviesRepository {

    override fun getIdruideMovies() = flow{
        emit(Loading())
        try {
            val result = api.getTrendsMovies()
            emit(Success(result.toIdruideMovieList()))
        }catch (e : Exception){
            emit(Error<List<IdruideMovie>>(e.toString()))
        }
    }
}