package com.example.jetpackcompose.activities

import android.content.res.Configuration.UI_MODE_NIGHT_YES
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.navArgument
import com.example.jetpackcompose.fragment.create.CreateFragment
import com.example.jetpackcompose.fragment.details.DetailsFragment
import com.example.jetpackcompose.fragment.home.HomeFragment
import com.example.jetpackcompose.ui.theme.JetpackComposeTheme
import com.example.jetpackcompose.utils.Screen

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            JetpackComposeTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colors.background
                ) {
                    JetpackComposeAppScreen()
                }
            }
        }
    }
}


@Composable
fun JetpackComposeAppScreen() {
    val navController = rememberNavController()
    NavHost(navController = navController, startDestination = Screen.Home.screen) {


        composable(route = Screen.Home.screen) {

            HomeFragment(
                onClickToCreateScreen ={
                    navController.navigate(Screen.Create.screen)

                } ,
                onClickToDetailScreen = { employeeId ->
                    navController.navigate(Screen.Detail.createRoute(employeeId))
                }
            )
        }
        composable(route = Screen.Detail.screen,
            arguments = listOf(
                navArgument("employeeId") {
                    type = NavType.IntType
                },
            ),
        ) { backStackEntry ->
            val employeeId = backStackEntry.arguments?.getInt("employeeId")
            requireNotNull(employeeId) {
                "employeeId parameter wasn't found. Please make sure it's set!"
            }
            DetailsFragment(employeeId)
        }

        composable(route = Screen.Create.screen){
            CreateFragment()
        }
    }
}

@Preview(showBackground = true, uiMode = UI_MODE_NIGHT_YES)
@Composable
fun DefaultPreview() {
    JetpackComposeTheme {
        HomeFragment()
    }
}