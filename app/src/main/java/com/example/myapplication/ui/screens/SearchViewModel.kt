package com.example.myapplication.ui.screens

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.myapplication.data.remote.ApiClient
import com.example.myapplication.domain.Song
import com.example.myapplication.ui.UiState
import com.example.myapplication.ui.loadUiState
import kotlinx.coroutines.Job
import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch

class SearchViewModel : ViewModel() {

    var query by mutableStateOf("")
        private set

    private val _results = MutableStateFlow<UiState<List<Song>>>(UiState.Success(emptyList()))
    val results: StateFlow<UiState<List<Song>>> = _results.asStateFlow()

    private var searchJob: Job? = null

    fun onQueryChange(newQuery: String) {
        query = newQuery
        searchJob?.cancel()

        if (newQuery.isBlank()) {
            _results.value = UiState.Success(emptyList())
            return
        }

        _results.value = UiState.Loading
        searchJob = viewModelScope.launch {
            delay(300)
            _results.value = loadUiState { ApiClient.api.searchSongs(newQuery) }
        }
    }
}