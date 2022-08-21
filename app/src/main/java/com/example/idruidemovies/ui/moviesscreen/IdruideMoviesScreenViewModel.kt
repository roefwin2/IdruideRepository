package com.example.idruidemovies.ui.moviesscreen

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.idruidemovies.domain.models.IdruideMovie
import com.example.idruidemovies.domain.usecases.GetIdruideMoviesUseCase
import com.example.idruidemovies.utils.Loading
import com.example.idruidemovies.utils.Resource
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class IdruideMoviesScreenViewModel @Inject constructor(
    private val getIdruideMoviesUseCase: GetIdruideMoviesUseCase
) : ViewModel() {

    var state by mutableStateOf(MoviesScreen(Loading()))

    init {
        getIdruideMovies()
    }

    private fun getIdruideMovies() {
        viewModelScope.launch {
            getIdruideMoviesUseCase.invoke().collect {
                state = MoviesScreen(it)
            }
        }
    }
}

data class MoviesScreen(
    val list: Resource<List<IdruideMovie>>
)