package ru.looprich.timetracker

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import ru.looprich.timetracker.ui.navigation.AppNavigation
import ru.looprich.timetracker.ui.theme.TimeTrackerTheme

class MainActivity : ComponentActivity()
{
    override fun onCreate(savedInstanceState : Bundle?)
    {
        super.onCreate(savedInstanceState)

        val app = application as App

        setContent {
            TimeTrackerTheme {
                AppNavigation(app)
            }
        }
    }
}
