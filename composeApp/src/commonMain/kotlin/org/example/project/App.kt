package org.example.project

import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateListOf
import androidx.compose.runtime.remember
import org.example.project.features.home.presentation.HomeScreen
import org.example.project.features.home.presentation.NotificationScreen
import org.example.project.features.root.screens.ScreenHome
import org.example.project.features.root.screens.ScreenNotification

@Composable
fun App() {
    MaterialTheme {
        val backStack = remember { mutableStateListOf<Any>(ScreenHome) }
        val currentScreen = backStack.last()

        when (currentScreen) {
            is ScreenHome -> HomeScreen(
                onItemClick = { id ->
                    backStack.add(ScreenNotification(id = id))
                })

            is ScreenNotification -> NotificationScreen(
                id = currentScreen.id, onBack = {
                    backStack.removeLastOrNull()
                })
        }
    }
}


