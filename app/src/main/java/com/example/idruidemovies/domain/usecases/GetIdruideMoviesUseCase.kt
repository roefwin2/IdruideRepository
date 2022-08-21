package com.example.idruidemovies.domain.usecases

import com.example.idruidemovies.data.repository.IdruideMoviesRepositoryImpl
import com.example.idruidemovies.domain.models.IdruideMovie
import com.example.idruidemovies.domain.repository.IdruideMoviesRepository
import com.example.idruidemovies.utils.Resource
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map
import javax.inject.Inject

class GetIdruideMoviesUseCase @Inject constructor(
    private val idruideMoviesRepositoryImpl: IdruideMoviesRepositoryImpl
) {

    fun invoke(): Flow<Resource<List<IdruideMovie>>> {
        return idruideMoviesRepositoryImpl.getIdruideMovies().map {
            it
        }
    }
}