package com.example.myapplication.domain

import kotlinx.serialization.Serializable

@Serializable
data class HomeData(
    val madeForYou: List<Playlist>,
    val popular: List<Playlist>,
    val mood: List<Playlist>
)
