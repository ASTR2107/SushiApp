package com.example.sushidelevery.view.data

import android.os.Parcel
import android.os.Parcelable
import androidx.navigation.ActivityNavigator

/*
sealed class BottomMenuContent(
    val route: String,
    vararg params: String
) {
    val fullRoute: String = if (params.isEmpty()) route else {
        val builder = StringBuilder(route)
        params.forEach { builder.append("/{${it}") }
        builder.toString()
    }

    sealed class NotArgumentDestination(route: String): ActivityNavigator.Destination(route),
        Parcelable {
        operator fun invoke(): String = route
        override fun writeToParcel(parcel: Parcel, flags: Int) {

        }

        override fun describeContents(): Int {
            return 0
        }

        companion object CREATOR : Parcelable.Creator<NotArgumentDestination> {
            override fun createFromParcel(parcel: Parcel): NotArgumentDestination {
                return NotArgumentDestination(parcel)
            }

            override fun newArray(size: Int): Array<NotArgumentDestination?> {
                return arrayOfNulls(size)
            }
        }
    }
        object Autorization : BottomMenuContent("Autorization")
        object Autorization2 : BottomMenuContent("Autorization 2")
        object Autorization3 : BottomMenuContent("Autorization 3")
        object Autorization4 : BottomMenuContent("Autorization 4")


        object ActualMenu : BottomMenuContent("Популярное")
        object Promotions : BottomMenuContent("Скидки")
        object ForBonuses : BottomMenuContent("За Бонусы")

    }
*/