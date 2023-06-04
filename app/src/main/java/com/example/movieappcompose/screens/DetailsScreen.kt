package com.example.movieappcompose.screens

import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import coil.compose.rememberImagePainter
import com.example.movieappcompose.model.Movie
import com.example.movieappcompose.model.getMovies
import com.example.movieappcompose.widget.MovieRow

@Composable
fun DetailsScreen(navController: NavController, movieID: String?){
    val newMovieList = getMovies().filter { movie ->
        movie.id == movieID
    }
    val movie = newMovieList[0]
    Scaffold(topBar = {
        TopAppBar(
            backgroundColor = MaterialTheme.colors.primary,
            elevation = 5.dp
        ) {
            Row(horizontalArrangement = Arrangement.Start) {
                Icon(
                    imageVector = Icons.Default.ArrowBack,
                    contentDescription ="Arrow back",
                    modifier = Modifier.clickable {
                        navController.popBackStack()
                    }
                )
                Spacer(modifier = Modifier.width(100.dp))
                Text(text = "Movies")
            }
        }
    }) {
        Surface(
            modifier = Modifier
                .fillMaxWidth()
                .fillMaxHeight()
                .padding(it)
        ) {
            Column(
                verticalArrangement = Arrangement.Top,
                horizontalAlignment = Alignment.CenterHorizontally
            ) {
                MovieRow(movie)
                Spacer(modifier = Modifier.height(5.dp))
                Divider()
                MovieImagesSlider(movie)
            }
        }
    }

}

@Composable
private fun MovieImagesSlider(movie: Movie) {
    LazyRow {
        items(movie.images) {
            Card(
                elevation = 10.dp,
                modifier = Modifier
                    .size(240.dp)
                    .padding(10.dp)
            ) {
                Image(
                    painter = rememberImagePainter(data = it),
                    contentDescription = "image placeholder"
                )
            }
        }
    }
}