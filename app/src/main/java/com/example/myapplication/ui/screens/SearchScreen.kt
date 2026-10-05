package com.example.myapplication.ui.screens

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.myapplication.data.MockData
import com.example.myapplication.domain.Song
import com.example.myapplication.ui.components.PreviewWrapper
import com.example.myapplication.ui.components.SongRow


@Composable
fun SearchScreen(
    onSongClick: (Song) -> Unit,
    modifier: Modifier = Modifier
) {


    var query by remember { mutableStateOf("") }

    val filtered = if (query.isBlank()) {
        emptyList()
    } else {
        MockData.songs.filter {
            it.title.contains(query, ignoreCase = true) || it.artist.contains(query, ignoreCase = true)
        }
    }

    Column(
        modifier = modifier.fillMaxSize().padding(16.dp)
    ) {
        OutlinedTextField(
            value = query,
            onValueChange = {query = it},
            modifier = Modifier.fillMaxWidth(),
            label = { Text("Поиск") },
            placeholder = {Text("Название или исполнитель")},
            singleLine = true,
        )

        if(filtered.isEmpty() && query.isNotBlank()) {
            Text(
                text = "Ничего не найдено",
                modifier = Modifier.padding(top = 16.dp)
            )
        }

        LazyColumn(modifier = Modifier.padding(top = 8.dp)) {
            items(filtered, key = {it.id}) { song ->
                SongRow(
                    song = song,
                    onClick = { onSongClick(song) }
                )
            }
        }

    }
}


@Preview(showBackground = true)
@Composable
private fun SearchScreenPreview() {
    PreviewWrapper {
        SearchScreen(onSongClick = {})
    }
}