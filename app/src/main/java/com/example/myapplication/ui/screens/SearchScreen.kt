package com.example.myapplication.ui.screens

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.myapplication.data.MockData
import com.example.myapplication.domain.Song
import com.example.myapplication.ui.UiState
import com.example.myapplication.ui.components.PreviewWrapper
import com.example.myapplication.ui.components.SongRow

@Composable
fun SearchScreen(
    query: String,
    onQueryChange: (String) -> Unit,
    results: UiState<List<Song>>,
    onSongClick: (Song) -> Unit,
    modifier: Modifier = Modifier
) {
    Column(
        modifier = modifier
            .fillMaxSize()
            .padding(16.dp)
    ) {
        OutlinedTextField(
            value = query,
            onValueChange = onQueryChange,
            label = { Text("Поиск") },
            placeholder = { Text("Название или исполнитель") },
            singleLine = true,
            modifier = Modifier.fillMaxWidth()
        )

        when (results) {
            is UiState.Loading -> {
                CircularProgressIndicator(modifier = Modifier.padding(top = 16.dp))
            }

            is UiState.Error -> {
                Text(
                    text = results.message,
                    modifier = Modifier.padding(top = 16.dp)
                )
            }

            is UiState.Success -> {
                if (results.data.isEmpty() && query.isNotBlank()) {
                    Text(
                        text = "Ничего не найдено",
                        modifier = Modifier.padding(top = 16.dp)
                    )
                }

                LazyColumn(modifier = Modifier.padding(top = 8.dp)) {
                    items(results.data, key = { it.id }) { song ->
                        SongRow(
                            song = song,
                            onClick = { onSongClick(song) }
                        )
                    }
                }
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
private fun SearchScreenPreview() {
    PreviewWrapper {
        SearchScreen(
            query = "the",
            onQueryChange = { },
            results = UiState.Success(MockData.songs.take(3)),
            onSongClick = { }
        )
    }
}