package com.example.bottomnavigation.Navigation

import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.filled.Person
import androidx.compose.material.icons.filled.Search
import androidx.compose.material.icons.filled.Settings
import androidx.compose.ui.graphics.vector.ImageVector

sealed class ScreenObject(val route: String, val title: String, val icon: ImageVector) {
    object Home : ScreenObject("home", "Home", Icons.Default.Home)
    object Profile : ScreenObject("profile", "Profile", Icons.Default.Person)
    object Setting: ScreenObject("setting","Setting",Icons.Default.Settings)
    object Search: ScreenObject("search","Search",Icons.Default.Search)
}