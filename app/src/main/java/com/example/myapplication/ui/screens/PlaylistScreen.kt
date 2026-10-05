package com.example.myapplication.ui.screens

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.height
import com.example.myapplication.domain.Song
import com.example.myapplication.ui.components.samplePlaylistWithSongs
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.myapplication.domain.Playlist
import com.example.myapplication.ui.components.PreviewWrapper
import com.example.myapplication.ui.components.SongRow

@Composable
fun PlaylistScreen (
    playlist: Playlist,
    onSongClick: (Song) -> Unit,
    modifier: Modifier = Modifier
) {

    LazyColumn(modifier = Modifier.fillMaxSize(),
        contentPadding = PaddingValues(bottom = 16.dp)) {

        item {

            Column(modifier = Modifier.padding(16.dp)) {
                Box(
                    modifier = Modifier.fillMaxWidth()
                        .height(240.dp)
                        .background(Color(playlist.coverColor))
                )

                Text(
                    text = playlist.title,
                    fontSize = 28.sp,
                    fontWeight = FontWeight.Bold,
                    modifier = Modifier.padding(16.dp)
                )

                Text(
                    text = playlist.subtitle,
                    fontSize = 14.sp,
                    modifier = Modifier.padding(4.dp)
                )
            }

        }

        items(playlist.songs, key = {it.id}) { song ->
            SongRow(
                song = song,
                onClick = { onSongClick(song) }
            )
        }
    }
}

@Preview(showBackground = true)
@Composable
private fun PlaylistScreenPreview() {
    PreviewWrapper {
        PlaylistScreen(playlist = samplePlaylistWithSongs, onSongClick = {})
    }
}
