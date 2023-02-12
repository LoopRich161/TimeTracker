package ru.looprich.timetracker.presentation.projects

import androidx.compose.material.Scaffold
import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import ru.looprich.timetracker.App
import ru.looprich.timetracker.navigation.components.BottomNavigationPanel
import ru.looprich.timetracker.presentation.projects.components.AddProjectButton
import ru.looprich.timetracker.presentation.projects.components.ProjectsContent

@Composable
fun ProjectsScreen(
    app: App,
    navController: NavHostController
) {
    val projects = app.projectRepo.getUserProjects(app.user)

    Scaffold(
        content = { padding ->
            ProjectsContent(
                padding = padding,
                projects = projects
            )
        },
        floatingActionButton = {
            AddProjectButton()
        },
        bottomBar = {
            BottomNavigationPanel(
                navController = navController
            )
        }
    )

}
