package com.rodrigo.poketor

import androidx.compose.runtime.Composable
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.rodrigo.poketor.app.sets.SetsScreen
import com.rodrigo.poketor.app.sets.SetsViewModel

@Composable
fun AppNavHost(navController: NavHostController) {
    NavHost(navController = navController, startDestination = Screen.Sets.route) {
        composable(Screen.Sets.route) {
            val vm: SetsViewModel = hiltViewModel()
            SetsScreen(vm.setsState)
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