package com.soumya.mydailycost

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.core.splashscreen.SplashScreen.Companion.installSplashScreen
import com.soumya.mydailycost.presentation.navigation.AppNavGraph
import com.soumya.mydailycost.presentation.onBoarding.OnBoardingScreen
import com.soumya.mydailycost.ui.theme.MyDailyCostTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        installSplashScreen()
        setContent {
            MyDailyCostTheme(
                dynamicColor = false
            ) {
                Box(modifier = Modifier.background(MaterialTheme.colorScheme.background)) {
                    OnBoardingScreen()
                }
            }
        }
        /*setContent {
            MyDailyCostTheme {
                AppNavGraph()
            }
        }*/
    }
}

@Composable
fun Greeting(name: String, modifier: Modifier = Modifier) {
    Text(
        text = "Hello $name!",
        modifier = modifier
    )
}

@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    MyDailyCostTheme {
        Greeting("Android")
    }
}