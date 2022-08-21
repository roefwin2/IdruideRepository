package com.example.idruidemovies.domain.repository

import com.example.idruidemovies.domain.models.IdruideMovie
import com.example.idruidemovies.utils.Resource
import kotlinx.coroutines.flow.Flow

interface IdruideMoviesRepository {

    fun getIdruideMovies(): Flow<Resource<List<IdruideMovie>>>
}