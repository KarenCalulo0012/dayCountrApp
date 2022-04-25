package com.appscals.daycountr.presentation.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.appscals.daycountr.presentation.components.EventScreen
import com.appscals.daycountr.presentation.components.SettingsScreen

@Composable
fun FragmentNav(fragmentNavController: NavHostController) {
    NavHost(
        navController = fragmentNavController,
        startDestination = BottomNavData.Event.route.toString()
    ) {
        BottomNavData.Event.route?.let {
            composable(it) { EventScreen() }
        }
        BottomNavData.Settings.route?.let {
            composable(it) { SettingsScreen() }
        }
    }

}