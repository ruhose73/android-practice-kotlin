package com.example.myapplication.ui.components

import androidx.compose.runtime.Composable
import com.example.myapplication.data.MockData
import com.example.myapplication.domain.Playlist
import com.example.myapplication.domain.Song
import com.example.myapplication.ui.theme.MyApplicationTheme

@Composable
fun PreviewWrapper  (content: @Composable () -> Unit) {
    MyApplicationTheme {
        content()
    }
}

val samplePlaylist: Playlist = MockData.popular.first()
val samplePlaylistWithSongs: Playlist = MockData.madeForYou.first()
val sampleSong: Song = MockData.songs.first()