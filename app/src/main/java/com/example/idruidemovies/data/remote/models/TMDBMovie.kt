package com.example.idruidemovies.data.remote.models


import com.example.idruidemovies.data.remote.models.Result.Companion.toIdruideMovie
import com.example.idruidemovies.domain.models.IdruideMovie
import com.squareup.moshi.Json

data class TMDBMovie(
    @Json(name = "page")
    val page: Int,
    @Json(name = "results")
    val results: List<Result>,
    @Json(name = "total_pages")
    val totalPages: Int,
    @Json(name = "total_results")
    val totalResults: Int
) {
    companion object {
        fun TMDBMovie.toIdruideMovieList(): List<IdruideMovie> {
            return this.results.map { it.toIdruideMovie() }
        }
    }
}