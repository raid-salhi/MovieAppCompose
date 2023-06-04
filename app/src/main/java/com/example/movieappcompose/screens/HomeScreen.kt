package com.example.movieappcompose.screens

import android.widget.Toast
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.CornerSize
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.AccountBox
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.RectangleShape
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.example.movieappcompose.model.Movie
import com.example.movieappcompose.model.getMovies
import com.example.movieappcompose.navigation.MovieScreens
import com.example.movieappcompose.widget.MovieRow

@Composable
fun HomeScreen(
    navController: NavController){
    Scaffold(topBar = {
        TopAppBar(
            backgroundColor = MaterialTheme.colors.primary,
            elevation = 5.dp
        ) {
            Text(text = "Movies")
        }
    }) {
        MainContent(Modifier.padding(it),navController= navController)
    }

}
@Composable
fun MainContent(
    modifier: Modifier,
    moviesList : List<Movie> = getMovies(),
    navController: NavController
)
{
    Column(modifier=Modifier.padding(12.dp)) {
        LazyColumn {
            items(items = moviesList){
                MovieRow(it){
                    navController.navigate(route = MovieScreens.DetailsScreen.name+"/$it")
                }
            }
        }
    }
}
