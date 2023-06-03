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
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.example.movieappcompose.navigation.MovieScreens

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
    moviesList : List<String> = listOf("Avatar","Spidey","Jhon","The wick"),
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

@Composable
fun MovieRow(movieName: String,onItemClick : (String) -> Unit ) {
    Card(
        shape = RoundedCornerShape(corner = CornerSize(15.dp)),
        elevation = 10.dp,
        modifier = Modifier
            .padding(15.dp)
            .fillMaxWidth()
            .wrapContentHeight()
            .clickable {
                onItemClick(movieName)
            }
    ) {
        Row(
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.Start
        ) {
            Surface(
                shape = RectangleShape,
                elevation = 5.dp,
                modifier = Modifier
                    .size(100.dp)
                    .padding(10.dp)
            ) {
                Icon(imageVector = Icons.Default.AccountBox, contentDescription = "MoviePic")
            }
            Text(text = movieName)
        }
    }
}