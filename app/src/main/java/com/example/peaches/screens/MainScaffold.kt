package com.example.peaches.screens

import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.foundation.layout.defaultMinSize
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.navigationBarsPadding
import androidx.compose.foundation.layout.statusBarsPadding
import androidx.compose.foundation.layout.wrapContentHeight
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.NavigationBar
import androidx.compose.material3.NavigationBarItem
import androidx.compose.material3.Scaffold
import androidx.compose.material3.dynamicDarkColorScheme
import androidx.compose.material3.dynamicLightColorScheme
import androidx.compose.runtime.Composable
import androidx.compose.runtime.SideEffect
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import androidx.navigation.compose.currentBackStackEntryAsState
import androidx.navigation.compose.rememberNavController
import com.example.peaches.Navigation

@Composable
fun MainScaffold(){
    // these bottom three variables allow us to find out on which View we currently are at
    val controller: NavController = rememberNavController()
    val navBackStackEntry by controller.currentBackStackEntryAsState()
    val currentRoute = navBackStackEntry?.destination?.route

    val dynamicColors = if (isSystemInDarkTheme()) {
        dynamicDarkColorScheme(LocalContext.current)
    } else {
        dynamicLightColorScheme(LocalContext.current)
    }

    val bottomBar : @Composable () -> Unit = {
        NavigationBar (
            modifier = Modifier.navigationBarsPadding().height(50.dp),
            containerColor = dynamicColors.surfaceContainerLowest //"surfaceContainerLowest" is the closest to matching the system's navigation bar color
        ) {
            screensInNavBar.forEach {
                item ->
                val isSelected = currentRoute == item.navBarItemRoute
                val tint = if(isSelected) Color.Gray else Color.Black // CHANGE COLOR as needed

                NavigationBarItem(
                    selected = currentRoute == item.navBarItemRoute,
                    onClick = {
                        controller.navigate(item.navBarItemRoute)
                    },
                    icon = { Icon(painter = painterResource(id = item.navBarItemIcon), contentDescription = null) },
                    label = null
                )
            }
        }
    }

    Scaffold ( // NO SCAFFOLD STATE?? NOT SURE HOW TO HANDLE THIS SITUATION
        modifier = Modifier.fillMaxSize().statusBarsPadding(),
        bottomBar = bottomBar,
    ) {
        Navigation(navController = controller, pd = it)
    }
}

@Preview(showBackground = true)
@Composable
fun MainScaffoldPreview(){
    MainScaffold()
}