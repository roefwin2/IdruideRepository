package com.example.idruidemovies.domain.models

data class IdruideMovie(
    val posterUrl :String,
    val backdropUrl: String,
    val title :String,
    val description :String,
    val originalLanguage  :String,
    val popularity : Double,
    val releaseDate :String?,
    val voteAverage : Double
)
