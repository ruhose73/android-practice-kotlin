package com.example.myapplication.ui.screens

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

class LibraryViewModel : ViewModel() {

    private val _state = MutableStateFlow<UiState<List<Playlist>>>(UiState.Loading)
    val state: StateFlow<UiState<List<Playlist>>> = _state.asStateFlow()

    init {
        load()
    }

    fun load() {
        viewModelScope.launch {
            _state.value = UiState.Loading
            _state.value = loadUiState { ApiClient.api.getLibrary() }
        }
    }
}