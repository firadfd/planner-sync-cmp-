package org.example.project.features.home.presentation

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material3.AlertDialog
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.window.DialogProperties
import org.example.project.componants.CustomAppBar
import org.example.project.componants.EditTaskDialog
import org.example.project.componants.TaskDetailDialog
import org.example.project.componants.TaskItem
import org.jetbrains.compose.ui.tooling.preview.Preview

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun HomeScreen(modifier: Modifier = Modifier) {
    var showMainDialogue by remember { mutableStateOf(false) }
    var showDeleteDialogue by remember { mutableStateOf(false) }
    var showEditDialog by remember { mutableStateOf(false) }
    var selectedTitle by remember { mutableStateOf("") }
    var selectedDate by remember { mutableStateOf("") }
    var selectedId by remember { mutableStateOf("") }




    Scaffold(modifier = modifier, topBar = {
        CustomAppBar("Good Morning", "Here’s what's coming up today.", onNotificationCLick = {})
    }) { paddingValue ->

        if (showMainDialogue) {
            TaskDetailDialog(
                title = selectedTitle,
                date = selectedDate,
                onDismiss = { selectedTitle = ""; selectedDate = ""; showMainDialogue = false },
                onEdit = {
                    showMainDialogue = false
                    showEditDialog = true
                },
                onDelete = {
                    showMainDialogue = false
                    showDeleteDialogue = true
                })
        }
        if (showDeleteDialogue) {
            AlertDialog(
                onDismissRequest = { showDeleteDialogue = false },
                title = { Text("Are you sure?") },
                text = { Text("Do you want to delete this task?") },
                confirmButton = {
                    TextButton(onClick = { showDeleteDialogue = false }) {
                        Text("OK")
                    }
                },
                dismissButton = {
                    TextButton(onClick = { showDeleteDialogue = false }) {
                        Text("Cancel")
                    }
                },
                properties = DialogProperties(
                    dismissOnBackPress = true, dismissOnClickOutside = true
                )
            )
        }
        if (showEditDialog) {
            EditTaskDialog(
                initialTitle = selectedTitle,
                initialDate = selectedDate,
                onDismiss = { showEditDialog = false },
                onSave = { newTitle, newDate ->
                    showEditDialog = false
                })
        }

        Column(
            modifier = Modifier.fillMaxSize().padding(paddingValue),
            verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            LazyColumn {
                items(20) {
                    TaskItem(
                        id = "",
                        title = "Morning Exercise / Jogging",
                        date = "6:00 am 31 Dec 2025",
                        onItemClick = { id ->
                            selectedTitle = "Morning Exercise / Jogging"
                            selectedDate = "6:00am"
                            selectedId = id
                            showMainDialogue = true
                        })
                }
            }
        }

    }

}


@Preview
@Composable
fun PreviewHome(modifier: Modifier = Modifier) {
    HomeScreen()
}
