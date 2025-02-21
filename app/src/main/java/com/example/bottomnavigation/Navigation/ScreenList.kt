package com.example.bottomnavigation.Navigation

import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.NavController


import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.example.bottomnavigation.Screens.HomeScreen
import com.example.bottomnavigation.Screens.ProfileScreen
import com.example.bottomnavigation.Screens.SearchScreen
import com.example.bottomnavigation.Screens.SettingScreen

@Composable
fun ScreenList(modifier: Modifier = Modifier, navController: NavHostController) {
    NavHost(
        navController = navController,
        startDestination = ScreenObject.Home.route
    ) {
        composable(route = ScreenObject.Home.route) {
            HomeScreen()
        }
        composable(route = ScreenObject.Profile.route){
            ProfileScreen()
        }
        composable(route = ScreenObject.Setting.route){
            SettingScreen()
        }
        composable(route = ScreenObject.Search.route){
            SearchScreen()
        }
    }
}