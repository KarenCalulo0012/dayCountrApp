package com.appscals.daycountr.presentation.components

import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.rounded.*
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import androidx.navigation.compose.currentBackStackEntryAsState
import com.appscals.daycountr.presentation.navigation.BottomNavData

@Composable
fun AppBar() {
    var showMenu by remember { mutableStateOf(false) }
    TopAppBar(
        title = {
            Text(text = "DASHBOARD")
        },
        navigationIcon = {
            IconButton(onClick = {}) {
                Icon(Icons.Rounded.ArrowBack, "backIcon")
            }
        },
        actions = {
            IconButton(onClick = { /*TODO*/ }) {
                Icon(
                    imageVector = Icons.Rounded.Notifications,
                    contentDescription = "Notification"
                )
            }
            IconButton(onClick = { showMenu = !showMenu }) {
                Icon(
                    imageVector = Icons.Rounded.MoreVert,
                    contentDescription = "Menu"
                )
            }
            DropdownMenu(expanded = showMenu, onDismissRequest = { showMenu = false }) {
                DropdownMenuItem(onClick = { /*TODO*/ }) {
                    Icon(imageVector = Icons.Rounded.Edit, contentDescription = "Edit")
                    Text(text = "Edit", modifier = Modifier.padding(start = 8.dp))
                }
                DropdownMenuItem(onClick = { /*TODO*/ }) {
                    Icon(imageVector = Icons.Rounded.Delete, contentDescription = "Delete")
                    Text(text = "Delete", modifier = Modifier.padding(start = 8.dp))
                }
            }
        },
        backgroundColor = MaterialTheme.colors.secondary,
        contentColor = MaterialTheme.colors.background,
        elevation = 0.dp
    )
}

@Composable
fun BottomNavBar(navController: NavController) {
    val items = listOf(BottomNavData.Event, BottomNavData.Settings)
    BottomNavigation(
        backgroundColor = MaterialTheme.colors.primary,
        contentColor = Color.White
    ) {
        val navBackStackEntry by navController.currentBackStackEntryAsState()
        val currentRoute = navBackStackEntry?.destination?.route
        items.forEach { item ->
            BottomNavigationItem(
                selected = currentRoute == item.route,
                onClick = {
                    item.route?.let {
                        navController.navigate(it) {
                            navController.graph.startDestinationRoute?.let { route ->
                                popUpTo(route) {
                                    saveState = true
                                }
                            }
                            launchSingleTop = true
                            restoreState = true
                        }
                    }
                },
                selectedContentColor = Color.White,
                unselectedContentColor = Color.LightGray,

                icon = {
                    Icon(
                        imageVector = item.icon!!,
                        contentDescription = item.title,
                        modifier = Modifier.size(24.dp)
                    )
                },
                label = {
                    Text(
                        text = item.title!!,
                        fontSize = 14.sp,
                        modifier = Modifier.padding(top = 16.dp)
                    )
                },
                alwaysShowLabel = true,
            )
        }
    }
}

@Composable
fun FloatingActionBtn() {
    FloatingActionButton(
        onClick = { /*TODO*/ },
        backgroundColor = MaterialTheme.colors.primary,
        content = {
            Icon(imageVector = Icons.Rounded.Add, contentDescription = "", tint = Color.White)
        })
}