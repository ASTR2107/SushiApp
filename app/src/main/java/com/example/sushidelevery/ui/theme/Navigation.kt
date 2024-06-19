package com.example.sushidelevery.ui.theme

import android.content.Context
import androidx.compose.runtime.Composable
import androidx.compose.ui.platform.LocalContext
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.sushidelevery.view.Autorization
import com.example.sushidelevery.view.FoodScreen
import com.example.sushidelevery.view.News
import com.example.sushidelevery.view.Popular

/*
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
        composable("course_view") {
            News(navController = navController)
        }
        composable("food_screen") {
            FoodScreen(navController = navController)
        }
        composable("popular"){
            Popular(navController = navController)
        }
    }
}

*/




