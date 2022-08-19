package com.example.idruidemovies.data.remote.api

import com.example.idruidemovies.data.remote.models.TMDBMovie
import retrofit2.http.GET

interface IdruideMoviesApi {


    @GET("get-trending")
    suspend fun getTrendsMovies() : List<TMDBMovie>
}