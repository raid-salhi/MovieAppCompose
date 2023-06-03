package com.example.movieappcompose

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent

import androidx.compose.foundation.layout.padding
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
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
    fun MainContent(modifier: Modifier){
        Surface(color = MaterialTheme.colors.background) {
            Greeting(name = "Said", modifier =modifier )
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