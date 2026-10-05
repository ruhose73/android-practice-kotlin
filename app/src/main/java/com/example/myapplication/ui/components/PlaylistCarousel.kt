package com.example.myapplication.ui.components

import com.example.myapplication.data.MockData

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.myapplication.domain.Playlist


@Composable
fun PlaylistCarousel(
    title: String,
    playlists: List<Playlist>,
    onPlaylistClick: (Playlist) -> Unit,
    modifier: Modifier = Modifier
) {
    Column(
        modifier = modifier
    ) {

        Text(
            text = title,
            fontSize = 22.sp,
            fontWeight = FontWeight.Bold,
            maxLines = 1,
            modifier = Modifier.padding(horizontal = 16.dp, vertical = 8.dp)
        )

        LazyRow (contentPadding = PaddingValues(horizontal = 16.dp), horizontalArrangement = Arrangement.spacedBy(12.dp)) {
            items(playlists, key = {it.id}) { playlist ->
                PlaylistCard(
                    playlist = playlist,
                    onClick = {onPlaylistClick(playlist)}
                )
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
private fun PlaylistCarouselPreview() {
    PreviewWrapper {
        PlaylistCarousel(
            title = "Made for you",
            playlists = MockData.madeForYou,
            onPlaylistClick = {}
    ) }
}