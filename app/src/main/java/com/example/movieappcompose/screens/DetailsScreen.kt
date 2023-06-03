package com.example.movieappcompose.screens

import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.navigation.NavController

@Composable
fun DetailsScreen(navController: NavController, get: Any?){
    Text(text = get.toString())
}