package com.appscals.daycountr.presentation.components

import androidx.compose.material.DrawerValue
import androidx.compose.material.Scaffold
import androidx.compose.material.rememberDrawerState
import androidx.compose.material.rememberScaffoldState
import androidx.compose.runtime.Composable
import androidx.navigation.compose.rememberNavController
import com.appscals.daycountr.presentation.navigation.FragmentNav

@Composable
fun DashboardScreen() {
    val navController = rememberNavController()
    Scaffold(
        topBar = { AppBar() },
        bottomBar = { BottomNavBar(navController) }
    ) {
        FragmentNav(navController)
    }
}

@Composable
fun DashPreview() {
    AppBar()
}