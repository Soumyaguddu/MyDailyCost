package com.soumya.mydailycost.ui.navigation

import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.soumya.mydailycost.ui.home.HomeScreen
import com.soumya.mydailycost.ui.splash.SplashScreen

@Composable
fun AppNavGraph( modifier: Modifier = Modifier) {

    val navController: NavHostController = rememberNavController().apply {}


    NavHost(navController, startDestination = NavRoute.SplashScreen.value,modifier=modifier) {

        composable(NavRoute.SplashScreen.value) {
            SplashScreen(navController)
        }

        composable(NavRoute.HomeScreen.value) {
            HomeScreen()
        }
    }
}
sealed class NavRoute(
    val value: String,
) {
    data object SplashScreen : NavRoute("splash")
    data object HomeScreen : NavRoute("home")
}
@Preview
@Composable
fun AppNavGraphPreview() {
    AppNavGraph()
}

