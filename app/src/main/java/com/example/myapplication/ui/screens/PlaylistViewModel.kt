package com.example.myapplication.ui.screens


import androidx.lifecycle.SavedStateHandle
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.myapplication.data.remote.ApiClient
import com.example.myapplication.domain.Playlist
import com.example.myapplication.ui.UiState
import com.example.myapplication.ui.loadUiState
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch

class PlaylistViewModel(savedStateHandle: SavedStateHandle) : ViewModel() {

    private val playlistId: String = checkNotNull(savedStateHandle["playlistId"])

    private val _state = MutableStateFlow<UiState<Playlist>>(UiState.Loading)
    val state: StateFlow<UiState<Playlist>> = _state.asStateFlow()

    init {
        load()
    }

    fun load() {
        viewModelScope.launch {
            _state.value = UiState.Loading
            _state.value = loadUiState { ApiClient.api.getPlaylist(playlistId) }
        }
    }
}