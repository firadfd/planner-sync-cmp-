package org.example.project.componants

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.material3.pulltorefresh.PullToRefreshDefaults
import androidx.compose.material3.pulltorefresh.PullToRefreshState
import androidx.compose.material3.pulltorefresh.pullToRefresh
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.intl.Locale
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.DpSize
import androidx.compose.ui.unit.dp
import androidx.compose.ui.window.Dialog
import dev.darkokoa.datetimewheelpicker.WheelDateTimePicker
import dev.darkokoa.datetimewheelpicker.core.WheelPickerDefaults
import dev.darkokoa.datetimewheelpicker.core.format.MonthDisplayStyle
import dev.darkokoa.datetimewheelpicker.core.format.TimeFormat
import dev.darkokoa.datetimewheelpicker.core.format.dateFormatter
import dev.darkokoa.datetimewheelpicker.core.format.timeFormatter
import kotlinx.datetime.Clock
import kotlinx.datetime.LocalDateTime
import kotlinx.datetime.TimeZone
import kotlinx.datetime.toLocalDateTime
import org.jetbrains.compose.ui.tooling.preview.Preview

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun EditTaskDialog(
    initialTitle: String,
    initialDate: String,
    onDismiss: () -> Unit,
    onSave: (String, String) -> Unit
) {
    var editedTitle by remember { mutableStateOf(initialTitle) }
    var editedDate by remember { mutableStateOf(initialDate) }

    Dialog(onDismissRequest = onDismiss) {
        Surface(
            shape = RoundedCornerShape(16.dp),
            color = Color.White,
            tonalElevation = 8.dp,
            modifier = Modifier.fillMaxWidth()
        ) {
            Column(modifier = Modifier.padding(20.dp)) {
                Text(
                    text = "Edit Task",
                    style = MaterialTheme.typography.titleMedium,
                    color = Color.Black
                )

                Spacer(modifier = Modifier.height(16.dp))

                OutlinedTextField(
                    value = editedTitle,
                    onValueChange = { editedTitle = it },
                    label = { Text("Title") },
                    modifier = Modifier.fillMaxWidth()
                )
                Spacer(modifier = Modifier.height(12.dp))
                Text(
                    text = "Start Time :",
                    style = MaterialTheme.typography.titleSmall,
                    color = Color.Black
                )
                WheelDateTimePicker(
                    startDateTime = Clock.System.now()
                        .toLocalDateTime(TimeZone.currentSystemDefault()),
                    minDateTime =LocalDateTime(
                        year = 2000, monthNumber = 12, dayOfMonth = 31, hour = 5, minute = 30
                    ) ,
                    maxDateTime = LocalDateTime(
                        year = 2050, monthNumber = 12, dayOfMonth = 31, hour = 5, minute = 30
                    ),
                    dateFormatter = dateFormatter(
                        locale = Locale.current, monthDisplayStyle = MonthDisplayStyle.FULL
                    ),
                    timeFormatter = timeFormatter(
                        timeFormat = TimeFormat.AM_PM
                    ),
                    size = DpSize(250.dp, 40.dp),
                    rowCount = 1,
                    textStyle = TextStyle(
                        color = Color.Black,
                        fontSize = MaterialTheme.typography.titleMedium.fontSize,
                        fontFamily = MaterialTheme.typography.titleSmall.fontFamily
                    ),
                    textColor = Color.Black,
                    selectorProperties = WheelPickerDefaults.selectorProperties(
                        enabled = true,
                        shape = RoundedCornerShape(10.dp),
                        color = Color.Cyan.copy(alpha = 0.2f),
                        border = BorderStroke(1.dp, Color.Black)
                    )
                ) { snappedDateTime -> }

                Spacer(modifier = Modifier.height(20.dp))
                Text(
                    text = "End Time :",
                    style = MaterialTheme.typography.titleSmall,
                    color = Color.Black
                )
                WheelDateTimePicker(
                    startDateTime = Clock.System.now()
                        .toLocalDateTime(TimeZone.currentSystemDefault()),
                    minDateTime =LocalDateTime(
                        year = 2000, monthNumber = 12, dayOfMonth = 31, hour = 5, minute = 30
                    ) ,
                    maxDateTime = LocalDateTime(
                        year = 2050, monthNumber = 12, dayOfMonth = 31, hour = 5, minute = 30
                    ),
                    dateFormatter = dateFormatter(
                        locale = Locale.current, monthDisplayStyle = MonthDisplayStyle.FULL
                    ),
                    timeFormatter = timeFormatter(
                        timeFormat = TimeFormat.AM_PM
                    ),
                    size = DpSize(250.dp, 40.dp),
                    rowCount = 1,
                    textStyle = TextStyle(
                        color = Color.Black,
                        fontSize = MaterialTheme.typography.titleMedium.fontSize,
                        fontFamily = MaterialTheme.typography.titleSmall.fontFamily
                    ),
                    textColor = Color.Black,
                    selectorProperties = WheelPickerDefaults.selectorProperties(
                        enabled = true,
                        shape = RoundedCornerShape(10.dp),
                        color = Color.Cyan.copy(alpha = 0.2f),
                        border = BorderStroke(1.dp, Color.Black)
                    )
                ) { snappedDateTime -> }
                Spacer(modifier = Modifier.height(20.dp))

                Row(horizontalArrangement = Arrangement.End, modifier = Modifier.fillMaxWidth()) {
                    TextButton(onClick = onDismiss) {
                        Text("Cancel")
                    }
                    Spacer(modifier = Modifier.width(8.dp))
                    Button(onClick = {
                        onSave(editedTitle, editedDate)
                    }) {
                        Text("Save")
                    }
                }
            }
        }
    }
}



@Preview
@Composable
private fun ShowDatePicker() {
    EditTaskDialog(
        initialTitle = "Morning Exercise / Jogging",
        initialDate = "6:00am",
        onDismiss = {   },
        onSave = { newTitle, newDate ->

        })
}
