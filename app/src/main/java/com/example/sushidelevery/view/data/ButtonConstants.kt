package com.example.sushidelevery.view.data

import androidx.navigation.NavController

sealed class ButtonConstants(
    val title: String,
    val route: String,
){
    object ActualMenu : ButtonConstants("Популярное","popular")
    object Promotions : ButtonConstants("Скидки","promotions")
    object ForBonuses : ButtonConstants("За Бонусы","for_bonuses")

}