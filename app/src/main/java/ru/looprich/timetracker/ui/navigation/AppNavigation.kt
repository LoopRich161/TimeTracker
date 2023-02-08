package ru.looprich.timetracker.ui.navigation

import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import ru.looprich.timetracker.App
import ru.looprich.timetracker.ui.screens.login.LoginScreen
import ru.looprich.timetracker.ui.screens.projects.ProjectsScreen

@Composable
fun AppNavigation(
    app: App,
    navController: NavHostController
) {

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
                app = app
            )
        }

    }
}
