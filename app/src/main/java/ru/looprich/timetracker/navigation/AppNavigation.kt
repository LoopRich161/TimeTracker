package ru.looprich.timetracker.navigation

import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import ru.looprich.timetracker.App
import ru.looprich.timetracker.presentation.login.LoginScreen
import ru.looprich.timetracker.presentation.projects.ProjectsScreen

@Composable
fun AppNavigation(
    app: App
) {
    val navController = rememberNavController()

    val actions = remember(navController) {
        AppActions(navController)
    }

    NavHost(
        navController = navController, startDestination = AppDestinations.Login.route
    ) {

        composable(
            AppDestinations.Login.route
        ) {
            LoginScreen(
                app = app,
                navigateToProjects = actions.navigateToProjects
            )
        }

        composable(
            AppDestinations.Projects.route
        ) {
            ProjectsScreen(
                app = app,
                navController = navController
            )
        }

    }
}
