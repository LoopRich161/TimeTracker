package ru.looprich.timetracker.ui.navigation

import androidx.navigation.NavHostController

class AppActions(
    private val navController : NavHostController,
    private val routes : AppDestinations
)
{

    val navigateToProjects = {
        navController.navigate(routes.PROJECTS_ROUTE)
    }

    // Вернуться на предыдущий экран
    val navigateUp : () -> Unit = {
        navController.navigateUp()
    }
}