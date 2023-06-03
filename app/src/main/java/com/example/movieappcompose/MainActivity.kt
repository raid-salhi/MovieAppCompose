package com.example.movieappcompose

import android.os.Bundle
import android.widget.Toast
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
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
import com.example.movieappcompose.ui.theme.MovieAppComposeTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            MyApp {

            }
        }
    }

    @Composable
    fun Greeting(name: String, modifier: Modifier) {
        Text(
            text = "Hello $name!",
            modifier = modifier
        )
    }
    @Composable
    fun MainContent(
        modifier: Modifier,
        moviesList : List<String> = listOf("Avatar","Spidey","Jhon","The wick")
    )
    {
        Column(modifier=Modifier.padding(12.dp)) {
            LazyColumn {
                items(items = moviesList){
                    MovieRow(it){
                        Toast.makeText(this@MainActivity, it, Toast.LENGTH_SHORT).show()
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

    @Composable
    fun MyApp(content: @Composable () -> Unit) {

        MovieAppComposeTheme {
            // A surface container using the 'background' color from the theme
            Scaffold(topBar = {
                TopAppBar(
                    backgroundColor = MaterialTheme.colors.primary,
                    elevation = 5.dp
                ) {
                    Text(text = "Movies")
                }
            }) {
                MainContent(Modifier.padding(it))
            }
        }
    }

    @Preview(showBackground = true)
    @Composable
    fun DefaultPreview() {
        MyApp {
        }
    }
}