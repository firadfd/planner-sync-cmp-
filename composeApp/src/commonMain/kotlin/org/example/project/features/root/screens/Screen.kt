package org.example.project.features.root.screens

import kotlinx.serialization.Serializable

@Serializable
data object ScreenHome

@Serializable
data class ScreenNotification(val id: String)
