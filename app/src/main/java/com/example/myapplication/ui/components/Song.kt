package com.example.myapplication.ui.components

import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import com.example.myapplication.domain.Song

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
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
fun SongRow(
    song: Song,
    onClick: () -> Unit,
    modifier: Modifier = Modifier
) {
    Row (modifier = modifier
        .fillMaxWidth()
        .clickable(onClick = onClick)
        .padding(horizontal = 16.dp, vertical = 8.dp),
        verticalAlignment = Alignment.CenterVertically,
        horizontalArrangement = Arrangement.spacedBy(12.dp)
    ) {

            Box(
                modifier = Modifier.size(48.dp)
                    .clip(RoundedCornerShape(5.dp))
                    .background(Color(song.coverColor))
            )

            Column (modifier = Modifier.weight(1f)) {
                Text(
                    text = song.title,
                    fontSize = 15.sp,
                    fontWeight = FontWeight.Medium,
                    maxLines = 1,
                    overflow = TextOverflow.Ellipsis,
                )

                Text(
                    text = song.artist,
                    fontSize = 12.sp,
                    color = Color.Gray,
                    maxLines = 1,
                    overflow = TextOverflow.Ellipsis,
                )
            }

        Text(
            text = song.duration,
            fontSize = 12.sp,
            color = Color.Gray,
        )
        }
    }

@Preview(showBackground = true)
@Composable
private fun SongRowPreview() {
    PreviewWrapper { SongRow(song = sampleSong, onClick = {})}
}