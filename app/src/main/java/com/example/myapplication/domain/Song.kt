package com.example.myapplication.domain
import kotlinx.serialization.Serializable

@Serializable
data class Song(
    val id: String,
    val title: String,
    val artist: String,
    val duration: String,
    val coverColor: Long,
)