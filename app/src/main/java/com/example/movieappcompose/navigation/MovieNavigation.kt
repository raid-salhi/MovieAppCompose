package com.example.movieappcompose.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.navArgument
import com.example.movieappcompose.screens.DetailsScreen
import com.example.movieappcompose.screens.HomeScreen

@Composable
fun MovieNaviagtion(){
    val navController = rememberNavController()
    NavHost(navController = navController, startDestination = MovieScreens.HomeScreen.name){
        composable(route = MovieScreens.HomeScreen.name){
            HomeScreen(navController)
        }
        composable(
            route=MovieScreens.DetailsScreen.name+"/{movie}",
            arguments = listOf(navArgument("movie") { type = NavType.StringType })
        ){
            DetailsScreen(navController,it.arguments?.get("movie"))
        }
    }
}
