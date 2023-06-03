package com.example.movieappcompose.navigation

enum class MovieScreens {
    HomeScreen,
    DetailsScreen;
    companion object {
        fun fromRoute(route:String?): MovieScreens =
            when(route?.substringBefore("/")){
                HomeScreen.name -> HomeScreen
                DetailsScreen.name -> DetailsScreen
                null -> HomeScreen
                else -> throw IllegalArgumentException("route $route isn't found")
            }

    }
}