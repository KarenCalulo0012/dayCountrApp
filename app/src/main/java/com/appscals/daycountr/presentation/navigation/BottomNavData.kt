package com.appscals.daycountr.presentation.navigation

import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.rounded.Event
import androidx.compose.material.icons.rounded.Settings
import androidx.compose.ui.graphics.vector.ImageVector

sealed class BottomNavData(
    var route: String? = null,
    var icon: ImageVector? = null,
    var title: String? = null
) {
    object Event : BottomNavData("eventScreen", icon = Icons.Rounded.Event, title = "Events")
    object Settings :
        BottomNavData("settingScreen", icon = Icons.Rounded.Settings, title = "Settings")
}
