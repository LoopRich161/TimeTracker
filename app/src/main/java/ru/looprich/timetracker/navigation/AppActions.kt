package ru.looprich.timetracker.navigation

import androidx.navigation.NavHostController

class AppActions(
    private val navController: NavHostController
) {

    val navigateToProjects = {
        navController.navigate(AppDestinations.Projects.route)
    }

}