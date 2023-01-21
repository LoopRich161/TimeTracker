package ru.looprich.timetracker.ui.navigation

import androidx.navigation.NavHostController

class AppActions(
    private val navController: NavHostController
) {

    val navigateToProjects = {
        navController.navigate(AppDestinations.PROJECTS_ROUTE.route)
    }

    // Вернуться на предыдущий экран
    val navigateUp: () -> Unit = {
        navController.navigateUp()
    }
}