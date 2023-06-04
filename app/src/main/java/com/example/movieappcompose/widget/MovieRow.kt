package com.example.movieappcompose.widget

import androidx.compose.animation.AnimatedVisibility
import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.CornerSize
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.AccountBox
import androidx.compose.material.icons.filled.KeyboardArrowDown
import androidx.compose.material.icons.filled.KeyboardArrowUp
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.RectangleShape

import androidx.compose.ui.text.SpanStyle
import androidx.compose.ui.text.buildAnnotatedString

import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.withStyle
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import coil.compose.rememberImagePainter
import coil.transform.CircleCropTransformation
import com.example.movieappcompose.model.Movie
import com.example.movieappcompose.model.getMovies
import kotlin.text.Typography

@Preview
@Composable
fun MovieRow(movie: Movie = getMovies()[0], onItemClick : (String) -> Unit ={}) {
    var isExpanded by remember {
                mutableStateOf(false)
    }
    Card(
        shape = RoundedCornerShape(corner = CornerSize(15.dp)),
        elevation = 10.dp,
        modifier = Modifier
            .padding(15.dp)
            .fillMaxWidth()
            .wrapContentHeight()
            .clickable {
                onItemClick(movie.id)
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
                Image(
                    painter = rememberImagePainter(
                        data = movie.images[0],
                        builder = {
                            crossfade(true)
                            transformations(CircleCropTransformation())
                }),
                    contentDescription = null
                )
            }
            Column(
                modifier = Modifier
                    .padding(5.dp),
                verticalArrangement = Arrangement.Center,
                horizontalAlignment = Alignment.Start

            ) {
                Text(
                    text = movie.title,
                    style = MaterialTheme.typography.h6,
                    fontWeight = FontWeight.Bold
                )
                Text(text = "Year : ${movie.year}", style = MaterialTheme.typography.caption)
                Text(text = "Director : ${movie.director}",style = MaterialTheme.typography.caption)
                AnimatedVisibility(visible = isExpanded) {
                    Column {
                        Text(buildAnnotatedString {
                            withStyle(style = SpanStyle(color = Color.Gray, fontSize = 12.sp)){
                                append("Plot : ")
                            }
                            withStyle(style = SpanStyle(color = Color.DarkGray, fontWeight = FontWeight.Bold, fontSize = 12.sp )){
                                append(movie.plot)
                            }

                        })
                        Spacer(modifier = Modifier.height(3.dp))
                        Divider(
                            thickness = 1.dp,
                            modifier = Modifier.fillMaxWidth()
                        )
                        Text(text = "Rating : ${movie.rating}", style = MaterialTheme.typography.caption)
                        Text(text = "Actors : ${movie.actors}",style = MaterialTheme.typography.caption)
                    }
                }

                Icon(
                    imageVector = if(!isExpanded) Icons.Filled.KeyboardArrowDown else Icons.Filled.KeyboardArrowUp,
                    contentDescription =null,
                    modifier = Modifier.clickable {
                        isExpanded = !isExpanded
                } )
            }
        }
    }
}