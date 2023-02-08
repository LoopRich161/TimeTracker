package ru.looprich.timetracker.ui.screens.projects

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.onGloballyPositioned
import androidx.compose.ui.platform.LocalDensity
import androidx.compose.ui.unit.dp
import ru.looprich.timetracker.App
import ru.looprich.timetracker.models.Project

@Composable
fun ProjectsScreen(
    app: App
) {

//    val projects =
//        app.projectRepo.getUserProjects(app.userAndProject.getUserProjectsId(app.user.id))

    val projects = mutableListOf<Project>()
    for (i in 1..50) {
        projects.add(Project(name = "Project #$i"))
    }

    var fabHeight by remember {
        mutableStateOf(0)
    }

    val heightInDp = with(LocalDensity.current) { fabHeight.toDp() }

    Scaffold(
        modifier = Modifier.padding(bottom = 56.dp), // 56.dp it's BottomNavigationPanel
        floatingActionButton = {
            FloatingActionButton(
                modifier = Modifier.onGloballyPositioned {
                    fabHeight = it.size.height
                },
                shape = CircleShape,
                onClick = { createProject() },
            ) {
                Icon(imageVector = Icons.Filled.Add, contentDescription = "Create project")
            }
        },
        floatingActionButtonPosition = FabPosition.End
    ) {
        LazyColumn(
            modifier = Modifier
                .fillMaxSize()
                .padding(it),
            contentPadding = PaddingValues(bottom = heightInDp)
        ) {
            items(projects) { project ->
                CardProject(project = project)
            }
        }
    }

}

@Composable
fun CardProject(project: Project) {
    Card(
        modifier = Modifier
            .padding(10.dp)
            .fillMaxWidth()
            .wrapContentHeight(),
        shape = MaterialTheme.shapes.medium,
        elevation = 5.dp,
        backgroundColor = MaterialTheme.colors.surface
    ) {
        Row(
            verticalAlignment = Alignment.CenterVertically,
        ) {
            Column(Modifier.padding(8.dp)) {
                Text(
                    text = project.name,
                    style = MaterialTheme.typography.h2,
                    modifier = Modifier
                        .padding(bottom = 8.dp)
                        .fillMaxWidth(),
                    color = MaterialTheme.colors.onSurface,
                )
            }
        }
    }
}


fun createProject() {

}