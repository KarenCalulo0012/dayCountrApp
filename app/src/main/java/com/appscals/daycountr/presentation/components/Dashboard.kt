package com.appscals.daycountr.presentation.components

import androidx.compose.material.Scaffold
import androidx.compose.runtime.Composable
import androidx.navigation.compose.rememberNavController
import com.appscals.daycountr.presentation.navigation.FragmentNav

@Composable
fun DashboardScreen() {
    val navController = rememberNavController()
    Scaffold(
        topBar = { AppBar() },
        bottomBar = { BottomNavBar(navController) },
        floatingActionButton = { FloatingActionBtn() }
    ) {
        FragmentNav(navController)
    }
}

@Composable
fun DashPreview() {
    AppBar()
}