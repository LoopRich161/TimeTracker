package ru.looprich.timetracker.ui.navigation

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.material.Button
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import ru.looprich.timetracker.ui.screens.login.LoginScreen
import ru.looprich.timetracker.ui.screens.projects.ProjectsScreen

@Composable
fun AppNavigation(
    startDestination : String = AppDestinations.LOGIN_ROUTE, routes : AppDestinations = AppDestinations
)
{

    val navController = rememberNavController()
    val actions = remember(navController) {
        AppActions(navController, routes)
    }

    NavHost(
        navController = navController, startDestination = startDestination
    ) {

        composable(
            AppDestinations.LOGIN_ROUTE
        ) {
            LoginScreen(
                navigateToProjects = actions.navigateToProjects
            )
        }

        composable(
            AppDestinations.PROJECTS_ROUTE
        ) {
            ProjectsScreen(

            )
        }

    }
}

