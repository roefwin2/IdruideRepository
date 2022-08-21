package com.example.idruidemovies.presenter

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Star
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import coil.compose.rememberAsyncImagePainter
import com.example.idruidemovies.domain.models.IdruideMovie
import com.example.idruidemovies.ui.moviesscreen.IdruideMoviesScreenViewModel
import com.example.idruidemovies.ui.theme.IdruideMoviesTheme
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            IdruideMoviesTheme {
                // A surface container using the 'background' color from the theme
                Surface(color = MaterialTheme.colors.background) {
                    Movies()
                }
            }
        }
    }
}

@Composable
fun Movies(
    viewModel: IdruideMoviesScreenViewModel = hiltViewModel()
) {
    LazyRow() {
        val list = viewModel.state.list.value
        list?.let {
            items(it) { item: IdruideMovie ->
                MovieItem(movie = item)
            }
        }
    }
}

@Composable
fun RatingItem(value: String) {
    Row(Modifier.padding(top = 4.dp, bottom = 4.dp)) {
        Icon(Icons.Default.Star, contentDescription = "Rating")
        Text(modifier = Modifier.padding(start = 4.dp), text = value)
    }
}


@Composable
fun MovieItem(movie: IdruideMovie) {
    Card(
        modifier = Modifier
            .fillMaxWidth(2f)
            .padding(8.dp),
        backgroundColor = Color.LightGray
    ) {
        Row() {
            Image(
                painter = rememberAsyncImagePainter("https://image.tmdb.org/t/p/w500" + movie.posterUrl),
                contentDescription = null,
                modifier = Modifier.size(128.dp)
            )
            Column() {
                Text(text = movie.title)
                RatingItem(value = movie.voteAverage.toString())
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
fun DefaultPreview() {
    IdruideMoviesTheme {
    }
}