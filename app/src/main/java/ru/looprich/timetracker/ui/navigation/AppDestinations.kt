package ru.looprich.timetracker.ui.navigation

import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Create
import androidx.compose.material.icons.filled.List
import androidx.compose.ui.graphics.vector.ImageVector

sealed class AppDestinations(val title: String, val icon: ImageVector, val route: String) {
    object Login : AppDestinations("Login", Icons.Default.Create, "login")
    object Projects : AppDestinations("Project", Icons.Default.List, "projects")
}