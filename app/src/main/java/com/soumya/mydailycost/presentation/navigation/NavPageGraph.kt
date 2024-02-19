package com.soumya.mydailycost.presentation.navigation

import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.soumya.mydailycost.presentation.home.HomeScreen


@Composable
fun AppNavGraph( modifier: Modifier = Modifier) {

    val navController: NavHostController = rememberNavController().apply {}


    NavHost(navController, startDestination = NavRoute.HomeScreen.value,modifier=modifier) {


        composable(NavRoute.HomeScreen.value) {
            HomeScreen()
        }
    }
}
sealed class NavRoute(
    val value: String,
) {

    data object HomeScreen : NavRoute("home")
}
@Preview
@Composable
fun AppNavGraphPreview() {
    AppNavGraph()
}

