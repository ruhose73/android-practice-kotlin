package com.example.myapplication.ui.screens

import androidx.lifecycle.SavedStateHandle
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.myapplication.data.remote.ApiClient
import com.example.myapplication.domain.Song
import com.example.myapplication.ui.UiState
import com.example.myapplication.ui.loadUiState
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch

class SongViewModel(savedStateHandle: SavedStateHandle) : ViewModel() {

    private val songId: String = checkNotNull(savedStateHandle["songId"])

    private val _state = MutableStateFlow<UiState<Song>>(UiState.Loading)
    val state: StateFlow<UiState<Song>> = _state.asStateFlow()

    init {
        load()
    }

    fun load() {
        viewModelScope.launch {
            _state.value = UiState.Loading
            _state.value = loadUiState { ApiClient.api.getSong(songId) }
        }
    }
}