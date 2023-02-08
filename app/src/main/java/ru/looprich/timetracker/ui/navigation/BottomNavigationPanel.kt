package ru.looprich.timetracker.ui.navigation

import androidx.compose.material.BottomNavigation
import androidx.compose.material.BottomNavigationItem
import androidx.compose.material.Icon
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import androidx.navigation.compose.currentBackStackEntryAsState
import ru.looprich.timetracker.ui.theme.colorWhite

@Composable
fun BottomNavigationPanel(navController: NavController) {
    val items = listOf(
        AppDestinations.Projects
    )

    val navBackStackEntry by navController.currentBackStackEntryAsState()
    val currentRoute = navBackStackEntry?.destination?.route

    if (currentRoute == AppDestinations.Login.route) {
        return
    }

    BottomNavigation(
        backgroundColor = colorWhite, contentColor = Color.Black
    ) {

        items.forEach { item ->
            BottomNavigationItem(icon = { Icon(item.icon, contentDescription = item.title) },
                label = {
                    Text(
                        text = item.title, fontSize = 9.sp
                    )
                },
                selectedContentColor = Color.Black,
                unselectedContentColor = Color.Black.copy(0.4f),
                alwaysShowLabel = true,
                selected = currentRoute == item.route,
                onClick = {
                    navController.navigate(item.route) {

                        navController.graph.startDestinationRoute?.let { screenRoute ->
                            popUpTo(screenRoute) {
                                saveState = true
                            }
                        }
                        launchSingleTop = true
                        restoreState = true
                    }
                })
        }
    }
}