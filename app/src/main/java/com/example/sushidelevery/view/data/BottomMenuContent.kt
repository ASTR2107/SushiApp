package com.example.sushidelevery.view.data

import androidx.navigation.NavController

sealed class BottomMenuContent(
    val title: String,
    val route: String,
    val iconId: Int
){
    object Autorization: BottomMenuContent("Autorization", "autorization",1)
    object Autorization2: BottomMenuContent("Autorization 2", "autorization_2",2)
    object Autorization3: BottomMenuContent("Autorization 3", "autorization_3",3)
    object Autorization4: BottomMenuContent("Autorization 4", "autorization_4",4)



}
