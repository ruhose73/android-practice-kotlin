package com.example.myapplication.ui.components

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.myapplication.domain.Playlist


@Composable
fun PlaylistCard(
    playlist: Playlist,
    onClick: () -> Unit,
    modifier: Modifier = Modifier
) {
    Column(
        modifier = modifier
            .width(160.dp)
            .clickable(onClick = onClick)
    ) {
        Box(
            modifier = Modifier.size(160.dp)
                .clip(RoundedCornerShape(9.dp))
                .background(Color(playlist.coverColor))
        )

        Text(
            text = playlist.title,
            fontSize = 14.sp,
            fontWeight = FontWeight.SemiBold,
            maxLines = 1,
            modifier = Modifier.padding(top = 8.dp),
            overflow = TextOverflow.Ellipsis,
        )

        Text(
            text = playlist.subtitle,
            fontSize = 12.sp,
            color = Color.Gray,
            maxLines = 1,
            overflow = TextOverflow.Ellipsis,
        )
    }
}

@Preview(showBackground = true)
@Composable
private fun PlaylistCardPreview() {
    PreviewWrapper { PlaylistCard(playlist = samplePlaylist, onClick = {}) }
}