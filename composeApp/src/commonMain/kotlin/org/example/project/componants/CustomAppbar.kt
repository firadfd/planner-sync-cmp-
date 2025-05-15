package org.example.project.componants

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.padding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.outlined.Notifications
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp


@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun CustomAppBar(time: String, title: String, onNotificationCLick: () -> Unit) {
    TopAppBar(modifier = Modifier.padding(horizontal = 10.dp), colors = TopAppBarDefaults.topAppBarColors(
    ), title = {
        Column(horizontalAlignment = Alignment.Start) {
            Text(
                time, style = TextStyle(
                    fontSize = 20.sp,
                    lineHeight = 28.sp,
                    fontWeight = FontWeight.W600,
                    color = Color(0xFF2D2D2D),
                    )
            )
            Text(
                title, style = TextStyle(
                    fontSize = 14.sp,
                    lineHeight = 19.6.sp,
                    fontWeight = FontWeight.W400,
                    color = Color(0xFF636F85),
                    )
            )
        }
    }, actions = {
        IconButton(onClick = onNotificationCLick, modifier = Modifier.padding(end = 10.dp)) {
            Icon(Icons.Outlined.Notifications, contentDescription = "")
        }
    })
}