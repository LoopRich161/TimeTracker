package ru.looprich.timetracker

import android.annotation.SuppressLint
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.material.Scaffold
import androidx.navigation.compose.rememberNavController
import ru.looprich.timetracker.ui.navigation.AppNavigation
import ru.looprich.timetracker.ui.navigation.BottomNavigationPanel
import ru.looprich.timetracker.ui.theme.TimeTrackerTheme

class MainActivity : ComponentActivity() {

    @SuppressLint("UnusedMaterialScaffoldPaddingParameter")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        val app = application as App

        setContent {
            TimeTrackerTheme {

                val navController = rememberNavController()

                Scaffold(bottomBar = { BottomNavigationPanel(navController = navController) }) {
                    AppNavigation(app = app, navController = navController)
                }

            }
        }
    }
}
