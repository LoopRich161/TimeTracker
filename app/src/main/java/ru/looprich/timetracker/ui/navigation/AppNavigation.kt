package ru.looprich.timetracker.ui.navigation

import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import ru.looprich.timetracker.App
import ru.looprich.timetracker.ui.screens.login.LoginScreen
import ru.looprich.timetracker.ui.screens.projects.ProjectsScreen

@Composable
fun AppNavigation(
    app: App,
    startDestination: String = AppDestinations.LOGIN_ROUTE.route
) {

    val navController = rememberNavController()
    val actions = remember(navController) {
        AppActions(navController)
    }

    NavHost(
        navController = navController, startDestination = startDestination
    ) {

        composable(
            AppDestinations.LOGIN_ROUTE.route
        ) {
            LoginScreen(
                app,
                navigateToProjects = actions.navigateToProjects
            )
        }

        composable(
            AppDestinations.PROJECTS_ROUTE.route
        ) {
            ProjectsScreen(

            )
        }

    }
}

