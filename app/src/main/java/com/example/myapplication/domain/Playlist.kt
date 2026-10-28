package com.example.myapplication.domain

import kotlinx.serialization.Serializable

@Serializable
data class Playlist(
    val id: String,
    val title: String,
    val subtitle: String,
    val coverColor: Long,
    val songs: List<Song> = emptyList()
)