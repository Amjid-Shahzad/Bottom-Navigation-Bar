package com.example.bottomnavigation.Navigation

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CutCornerShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Icon
import androidx.compose.material3.NavigationBar
import androidx.compose.material3.NavigationBarItem
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHostController
import androidx.navigation.compose.currentBackStackEntryAsState

@Composable
fun MainScreen(modifier: Modifier = Modifier, navController: NavHostController) {

    Scaffold(bottomBar = { NavItem(navController = navController) }) { innerPadding ->
        ScreenList(modifier = Modifier.padding(innerPadding), navController)
    }
}

@Composable
fun NavItem(modifier: Modifier = Modifier, navController: NavHostController) {
    val activeColor = Color.Red
    val inActiveColor = Color.Black
    val screens = listOf(
        ScreenObject.Home,
        ScreenObject.Profile,
        ScreenObject.Setting,
        ScreenObject.Search
    )
    val navBackStackEntry by navController.currentBackStackEntryAsState()
    val currentDestination = navBackStackEntry?.destination?.route
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .height(80.dp)
            .clip(
                RoundedCornerShape(topStart = 15.dp, topEnd = 15.dp)
            )
            .background(Color.DarkGray)

    ) {
        screens.forEach { screen ->
            val isSelected = currentDestination == screen.route
            Box(modifier = Modifier
                .padding(2.dp)
                .clip(RoundedCornerShape(10.dp))
                .weight(1f)
                .clickable {
                    navController.navigate(screen.route)
                    { popUpTo(navController.graph.startDestinationId) }
                }
                .padding(5.dp),
                contentAlignment = Alignment.Center) {
                Column(
                    verticalArrangement = Arrangement.Center,
                    horizontalAlignment = Alignment.CenterHorizontally
                ) {
                    Icon(
                        screen.icon, contentDescription = screen.route,
                        modifier = Modifier.size(if (isSelected) 30.dp else 26.dp),
                        tint = if (isSelected) activeColor else inActiveColor
                    )
                    Text(
                        text = screen.title, fontSize = if (isSelected) 16.sp else 14.sp,
                        color = if (isSelected) activeColor else inActiveColor
                    )
                }
            }

        }
    }
}