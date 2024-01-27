package com.soumya.mydailycost.ui.splash

import androidx.compose.animation.AnimatedVisibility
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHostController
import com.soumya.mydailycost.R
import com.soumya.mydailycost.ui.navigation.NavRoute
import com.soumya.mydailycost.ui.theme.MyDailyCostTheme
import com.soumya.mydailycost.ui.theme.colorBackground
import kotlinx.coroutines.delay

@Composable
fun SplashScreen(navController: NavHostController?, modifier: Modifier = Modifier) {
    Box {
        Column(
            modifier = Modifier
                .fillMaxSize()
                .background(color = MaterialTheme.colors.colorBackground)
                .then(modifier),
            verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Spacer(modifier = Modifier.weight(1f))

            // Fade-in animation for the logo
            var visible by remember { mutableStateOf(false) }
            LaunchedEffect(key1 = true) {
                delay(300)
                visible = true
            }
            AnimatedVisibility(visible = visible) {
                AppLogo(modifier = Modifier.size(150.dp))
            }

            Spacer(modifier = Modifier.weight(1f))
            Text(
                modifier = Modifier.padding(all = 15.dp),
                text = "My Daily Cost!!",
                style = MaterialTheme.typography.caption.copy(
                    color = Color.Black,
                    fontSize = 20.sp,
                    fontFamily = FontFamily.Serif
                ),
                textAlign = TextAlign.Center,
            )
        }
    }

    LaunchedEffect(key1 = true) {
        delay(3000)
        navController?.navigate(NavRoute.HomeScreen.value) {
            popUpTo(NavRoute.SplashScreen.value) {
                inclusive = true // Remove the splash screen from the back stack
            }
        }
    }
}

@Composable
fun AppLogo(modifier: Modifier) {
    Image(
        modifier = modifier.fillMaxSize(),
        painter = painterResource(id = R.drawable.budget),
        contentDescription = "logo"
    )

}

@Preview
@Composable
fun SplashScreenPreview() {
    MyDailyCostTheme {

        SplashScreen(navController = null)
    }

}