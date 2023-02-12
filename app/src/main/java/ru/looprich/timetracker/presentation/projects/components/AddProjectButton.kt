package ru.looprich.timetracker.presentation.projects.components

import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.FloatingActionButton
import androidx.compose.material.Icon
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.onGloballyPositioned

@Composable
fun AddProjectButton() {
    FloatingActionButton(
        modifier = Modifier.onGloballyPositioned {
//            fabHeight = it.size.height
        },
        shape = CircleShape,
        onClick = { createProject() },
    ) {
        Icon(imageVector = Icons.Filled.Add, contentDescription = "Create project")
    }
}

fun createProject() {

}