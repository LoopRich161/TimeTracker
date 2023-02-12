package ru.looprich.timetracker.presentation.projects.components

import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import ru.looprich.timetracker.domain.repository.Projects

@Composable
fun ProjectsContent(
    padding: PaddingValues,
    projects: Projects
) {
    LazyColumn(
        modifier = Modifier
            .fillMaxSize()
            .padding(padding)
    ) {
        items(items = projects) { project ->
            CardProject(project = project)
        }
    }
}