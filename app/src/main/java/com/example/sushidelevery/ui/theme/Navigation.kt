package com.example.sushidelevery.ui.theme

import android.content.Context
import androidx.compose.runtime.Composable
import androidx.compose.ui.platform.LocalContext
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.sushidelevery.view.Autorization
import com.example.sushidelevery.view.HomeScreens
import com.example.sushidelevery.view.Popular


@Composable
fun Navigation() {
    val navController = rememberNavController()
    val context = LocalContext.current
    val sharedPreferences = context.getSharedPreferences("main", Context.MODE_PRIVATE)
    val userLoggedIn = sharedPreferences.getBoolean("loggedIn", false)
    NavHost(navController = navController, startDestination = if (userLoggedIn)"home_screens" else "autorization") {

        composable("autorization") {
            Autorization(navController = navController)
        }
        composable("home_screens") {
            HomeScreens(navController = navController)
        }
        composable("popular"){
            Popular(navController = navController)
        }
    }
}






