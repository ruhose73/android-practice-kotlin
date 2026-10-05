package com.example.myapplication.ui.screens

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
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
import com.example.myapplication.ui.components.PlaylistCard
import com.example.myapplication.ui.components.PlaylistCarousel
import com.example.myapplication.ui.components.PreviewWrapper
import com.example.myapplication.ui.components.SongRow

@Composable
fun LibraryScreen (
    onPlaylistClick: (Playlist) -> Unit,
    modifier: Modifier = Modifier
) {

    LazyColumn(modifier = Modifier.fillMaxSize(),
        contentPadding = PaddingValues(16.dp),
        verticalArrangement = Arrangement.spacedBy(12.dp)) {

        item {
            Text(
                text = "Ваша медиатека",
                fontSize = 28.sp,
                fontWeight = FontWeight.Bold,
                modifier = Modifier.padding(8.dp)
            )
        }

        items(MockData.library, key = {it.id}) { playlist ->
            PlaylistCard(
                playlist = playlist,
                onClick = { onPlaylistClick(playlist) }
            )
        }
    }
}

@Preview(showBackground = true)
@Composable
private fun LibraryScreenPreview() {
    PreviewWrapper {
        LibraryScreen(onPlaylistClick = {})
    }
}
