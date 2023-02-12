package ru.looprich.timetracker.presentation

import android.annotation.SuppressLint
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import ru.looprich.timetracker.App
import ru.looprich.timetracker.navigation.AppNavigation
import ru.looprich.timetracker.theme.TimeTrackerTheme

class MainActivity : ComponentActivity() {

    @SuppressLint("UnusedMaterialScaffoldPaddingParameter")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        val app = application as App

        setContent {
            TimeTrackerTheme {
                AppNavigation(app = app)
            }
        }
    }
}
