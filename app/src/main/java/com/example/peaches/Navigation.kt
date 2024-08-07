package com.example.peaches

import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.padding
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.peaches.screens.MapScreen
import com.example.peaches.screens.MessagesScreen
import com.example.peaches.screens.Screens
import com.example.peaches.screens.UserProfileScreen

@Composable
fun Navigation(navController: NavController, pd: PaddingValues){
    NavHost(
        navController = navController as NavHostController,
        startDestination = Screens.NavBarScreens.Map.navBarItemRoute,
        modifier = Modifier.padding(pd)
    ) {
        composable(route = Screens.NavBarScreens.Map.navBarItemRoute){
            MapScreen()
        }

        composable(route = Screens.NavBarScreens.Messages.navBarItemRoute){
            MessagesScreen()
        }

        composable(route = Screens.NavBarScreens.UserProfile.navBarItemRoute){
            UserProfileScreen()
        }
    }
}

@Preview(showBackground = false)
@Composable
fun NavigationPreview(){
    Navigation(navController = rememberNavController(), pd = PaddingValues(0.dp))
}