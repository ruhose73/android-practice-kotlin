package com.example.myapplication.ui.screens


import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.myapplication.domain.Song
import com.example.myapplication.ui.components.PreviewWrapper
import com.example.myapplication.ui.components.sampleSong

@Composable
fun SongScreen(
    song: Song,
    modifier: Modifier = Modifier
) {

    var isPlaying by remember { mutableStateOf(false) }

    Column(
        modifier = modifier
            .fillMaxSize()
            .padding(24.dp),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.spacedBy(24.dp)
    ) {
        Box(
            modifier = Modifier
                .size(280.dp)
                .clip(RoundedCornerShape(12.dp))
                .background(Color(song.coverColor))
        )

        Column(horizontalAlignment = Alignment.CenterHorizontally) {
            Text(
                text = song.title,
                fontSize = 24.sp,
                fontWeight = FontWeight.Bold,
                textAlign = TextAlign.Center
            )
            Text(
                text = song.artist,
                fontSize = 16.sp,
                color = Color.Gray,
                modifier = Modifier.padding(top = 4.dp)
            )
        }

        Row(
            modifier = Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.SpaceEvenly,
            verticalAlignment = Alignment.CenterVertically
        ) {
            Button(onClick = { }, shape = CircleShape, modifier = Modifier.size(56.dp)) {
                Text("⏮")
            }
            Button(onClick = { isPlaying = !isPlaying}, shape = CircleShape, modifier = Modifier.size(72.dp)) {
                Text(if (isPlaying) "⏸" else "▶", fontSize = 24.sp)
            }
            Button(onClick = { }, shape = CircleShape, modifier = Modifier.size(56.dp)) {
                Text("⏭")
            }
        }

        Text(
            text = song.duration,
            fontSize = 13.sp,
            color = Color.Gray
        )
    }
}

@Preview(showBackground = true)
@Composable
private fun SongScreenPreview() {
    PreviewWrapper {
        SongScreen(song = sampleSong)
    }
}