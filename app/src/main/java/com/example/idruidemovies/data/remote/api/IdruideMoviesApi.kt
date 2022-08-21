package com.example.idruidemovies.data.remote.api

import com.example.idruidemovies.data.remote.models.TMDBMovie
import retrofit2.http.GET

interface IdruideMoviesApi {


    @GET("day?api_key=2137c23263194c5a08d0b95e2c30a275")
    suspend fun getTrendsMovies(): TMDBMovie
}