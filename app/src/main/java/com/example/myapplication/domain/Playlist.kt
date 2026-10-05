package com.example.myapplication.domain

data class Playlist(
    val id: String,
    val title: String,
    val subtitle: String,
    val coverColor: Long,
    val songs: List<Song> = emptyList()
)