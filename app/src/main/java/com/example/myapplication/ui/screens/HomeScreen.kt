package com.example.myapplication.ui.screens

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.myapplication.data.MockData
import com.example.myapplication.domain.Playlist
import com.example.myapplication.ui.components.PlaylistCarousel
import com.example.myapplication.ui.components.PreviewWrapper

@Composable
fun HomeScreen (
    onPlaylistClick: (Playlist) -> Unit,
    modifier: Modifier = Modifier
) {
    Column(
        modifier = modifier.fillMaxSize().verticalScroll(rememberScrollState())
    ) {

        Text(
            text = "Добрый вечер",
            fontSize = 28.sp,
            fontWeight = FontWeight.Bold,
            modifier = Modifier.padding(16.dp)
        )

        PlaylistCarousel(title = "Made for you", playlists = MockData.madeForYou, onPlaylistClick = onPlaylistClick)

        PlaylistCarousel(title = "Popular", playlists = MockData.popular, onPlaylistClick = onPlaylistClick)

        PlaylistCarousel(title = "Mood", playlists = MockData.mood, onPlaylistClick = onPlaylistClick)

    }
}

@Preview(showBackground = true)
@Composable
private fun HomeScreenPreview() {
    PreviewWrapper {
        HomeScreen(onPlaylistClick = {})
    }
}
