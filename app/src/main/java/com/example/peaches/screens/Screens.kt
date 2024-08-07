package com.example.peaches.screens

import androidx.annotation.DrawableRes
import com.example.peaches.R

sealed class Screens(val title: String, val route: String) {
    sealed class NavBarScreens(
        val navBarItemTitle: String,
        val navBarItemRoute: String,
        @DrawableRes val navBarItemIcon: Int
    ) : Screens(navBarItemTitle, navBarItemRoute) {
        object Map : NavBarScreens("Map", "map", R.drawable.baseline_search_24)
        object Messages : NavBarScreens("Messages", "messages", R.drawable.baseline_message_24)
        object UserProfile : NavBarScreens("User Profile", "user_profile", R.drawable.baseline_account_circle_24)
    }
}

val screensInNavBar = listOf(
    Screens.NavBarScreens.Map,
    Screens.NavBarScreens.Messages,
    Screens.NavBarScreens.UserProfile
)