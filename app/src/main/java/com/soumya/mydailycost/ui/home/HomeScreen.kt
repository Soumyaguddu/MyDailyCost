package com.soumya.mydailycost.ui.home

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material.BottomNavigation
import androidx.compose.material.BottomNavigationItem
import androidx.compose.material.Icon
import androidx.compose.material.Scaffold
import androidx.compose.material.Text
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.filled.Person
import androidx.compose.material.icons.filled.Search
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.currentBackStackEntryAsState
import androidx.navigation.compose.rememberNavController
import com.soumya.mydailycost.utils.Constants

@Preview
@Composable
fun HomeScreen() {
    val navController = rememberNavController()
    Scaffold(
        //Bottom navigation
        bottomBar = {
            BottomNavigationBar(navController = navController)
        }, content = { padding ->

            //Navhost: where screens are placed
            NavHostContainer(navController = navController, padding = padding)
        }
    )
}

@Composable
fun BottomNavigationBar(navController: NavHostController) {


    BottomNavigation(
        //set background color
        backgroundColor = Color(0xFF2093C7),
        elevation = 15.dp
    ) {

        //observe the backstack
        val navBackStackEntry by navController.currentBackStackEntryAsState()

        //observe current route to change the icon color,label color when navigated
        val currentRoute = navBackStackEntry?.destination?.route

        //Bottom nav items we declared
        Constants.BottomNavItems.forEach { navItem ->

            //Place the bottom nav items
            BottomNavigationItem(
                //it currentRoute is equal then its selected route
                selected = currentRoute == navItem.route,

                //navigate on click
                onClick = {
                    navController.navigate(navItem.route)
                },
                //Icon of navItem
                icon = {
                    Icon(imageVector = navItem.icon, contentDescription = navItem.label)
                },
                //label
                label = {
                    Text(text = navItem.label, style = TextStyle(color = Color.DarkGray))
                }, selectedContentColor = Color.Black,
                unselectedContentColor = Color.Gray,
                alwaysShowLabel = false
            )
        }


    }
}

/**
 * It receives navcontroller to navigate between screens,
 * padding values -> Since BottomNavigation has some heights,
 * to avoid clipping of screen, we set padding provided by scaffold
 */
@Composable
fun NavHostContainer(
    navController: NavHostController,
    padding: PaddingValues
) {

    NavHost(
        navController = navController,

        //set the start destination as home
        startDestination = "home",

        //Set the padding provided by scaffold
        modifier = Modifier.padding(paddingValues = padding),

        builder = {

            //  route : Home
            composable("home") {
                HomeViewScreen("Home")
            }



            //  route : profile
            composable("profile") {
                ProfileScreen("Profile")
            }
        })

}

@Composable
fun HomeViewScreen(name: String) {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(Color.White),
        // parameters set to place the items in center
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ) {


        //Icon Composable
        Icon(
            imageVector = Icons.Default.Home,
            contentDescription = "home",
            tint = Color(0xFF0F9D58)
        )
        //Text to Display the current Screen
        Text(text = name, color = Color.Black)

    }
}

@Composable
fun ProfileScreen(name: String) {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(Color.White),
        // parameters set to place the items in center
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ) {


        //Icon Composable
        Icon(
            imageVector = Icons.Default.Person,
            contentDescription = "profile",
            tint = Color(0xFF0F9D58)
        )
        //Text to Display the current Screen
        Text(text = name, color = Color.Black)

    }
}


