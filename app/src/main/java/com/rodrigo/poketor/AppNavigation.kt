package com.rodrigo.poketor

import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.rodrigo.poketor.app.sets.SetsScreen

@Composable
fun AppNavHost(navController: NavHostController) {
    NavHost(navController = navController, startDestination = Screen.Sets.route) {
        composable(Screen.Sets.route) {
            SetsScreen()
        }
    }
}

@Composable
fun AppNavigation() {
    val navController = rememberNavController()
    AppNavHost(navController = navController)
}


sealed class Screen(val route:String){
    object Sets: Screen("sets")
}