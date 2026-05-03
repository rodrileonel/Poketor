package com.rodrigo.poketor

import androidx.compose.runtime.Composable
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.rodrigo.poketor.app.cards.CardsScreen
import com.rodrigo.poketor.app.cards.CardsViewModel
import com.rodrigo.poketor.app.sets.SetsScreen
import com.rodrigo.poketor.app.sets.SetsViewModel

@Composable
fun AppNavHost(navController: NavHostController) {
    NavHost(navController = navController, startDestination = Screen.Sets.route) {
        composable(Screen.Sets.route) {
            val vm: SetsViewModel = hiltViewModel()
            SetsScreen(
                vm.setsState,
                onNavigateToCards = { setId ->
                    navController.navigate(
                        Screen.Cards.createRouteFromSet(setId)
                    )
                }
            )
        }
        composable(Screen.Cards.route) { backStackEntry ->
            //val from = backStackEntry.arguments?.getString("from") ?: ""
            //val filter = backStackEntry.arguments?.getString("filter") ?: ""
            val vm: CardsViewModel = hiltViewModel()
            CardsScreen(
                vm.cardsState,
                onBack = {navController.popBackStack()},
            )
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
    object Cards: Screen("cards/{from}/{filter}"){
        const val ARG_FROM = "from"
        const val ARG_FILTER = "filter"

        const val FROM_SET = "set"
        const val FROM_POKEMON = "pokemon"
        fun createRouteFromSet(setId:String) = "cards/$FROM_SET/$setId"
        fun createRouteFromPokemon(name:String) = "cards/$FROM_POKEMON/$name"
    }
}