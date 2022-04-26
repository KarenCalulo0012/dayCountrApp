package com.appscals.daycountr.presentation.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.appscals.daycountr.presentation.components.DashboardScreen
import com.appscals.daycountr.presentation.components.LoginScreen

@Composable
fun AppMain() {
    AppNavigation()
}


@Composable
fun AppNavigation() {
    val navController = rememberNavController()
    NavHost(navController = navController, startDestination = "login") {
        composable("login") { LoginScreen(navController) }
        composable("dashboardScreen") { DashboardScreen() }
    }
}