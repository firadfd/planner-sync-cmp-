package org.example.project.features.home.presentation

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBackIosNew
import androidx.compose.material3.CenterAlignedTopAppBar
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import org.example.project.core.utils.noRippleClickable
import org.jetbrains.compose.ui.tooling.preview.Preview


@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun NotificationScreen(id: String, onBack: () -> Unit, modifier: Modifier = Modifier) {
    Scaffold(
        topBar = {
            CenterAlignedTopAppBar(title = { Text("Notification") }, navigationIcon = {
                Icon(
                    Icons.Default.ArrowBackIosNew,
                    contentDescription = "Back",
                    modifier = Modifier.padding(all = 10.dp).noRippleClickable { onBack() })
            })
        }) { paddingValues ->
        Column(
            modifier = modifier.padding(paddingValues).fillMaxSize(),
            verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Text(
                text = "Notification Screen $id", color = Color.Blue
            )
        }
    }
}

@Preview
@Composable
private fun Show() {
    NotificationScreen(id = "10", onBack = {})
}
