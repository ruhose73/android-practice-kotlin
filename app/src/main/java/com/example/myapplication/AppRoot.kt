package com.example.myapplication

import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.myapplication.ui.screens.HomeScreen
import com.example.myapplication.ui.screens.LibraryScreen
import com.example.myapplication.ui.screens.SearchScreen


import androidx.compose.foundation.layout.padding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.filled.Menu
import androidx.compose.material.icons.filled.Search
import androidx.compose.material3.Icon
import androidx.compose.material3.NavigationBar
import androidx.compose.material3.NavigationBarItem
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.currentBackStackEntryAsState
import androidx.navigation.compose.rememberNavController
import com.example.myapplication.data.MockData
import com.example.myapplication.ui.components.UiStateContent
import com.example.myapplication.ui.screens.HomeScreen
import com.example.myapplication.ui.screens.HomeViewModel
import com.example.myapplication.ui.screens.LibraryScreen
import com.example.myapplication.ui.screens.LibraryViewModel
import com.example.myapplication.ui.screens.PlaylistScreen
import com.example.myapplication.ui.screens.PlaylistViewModel
import com.example.myapplication.ui.screens.SearchScreen
import com.example.myapplication.ui.screens.SearchViewModel
import com.example.myapplication.ui.screens.SongScreen
import com.example.myapplication.ui.screens.SongViewModel


object Routes {
    const val HOME = "home"
    const val SEARCH = "search"
    const val LIBRARY = "library"
    const val PLAYLIST = "playlist/{playlistId}"
    const val SONG = "song/{songId}"

    fun playlist(id: String) = "playlist/$id"
    fun song(id: String) = "song/$id"
}

@Composable
fun AppRoot(modifier: Modifier = Modifier) {
    val navController = rememberNavController()

    Scaffold(
        modifier = modifier,
        bottomBar = { BottomBar(navController) }
    ) { innerPadding ->
        NavHost(
            navController = navController,
            startDestination = Routes.HOME,
            modifier = Modifier.padding(innerPadding)
        ) {
            composable(Routes.HOME) {
                val viewModel: HomeViewModel = viewModel()
                val state by viewModel.state.collectAsState()
                UiStateContent(state = state, onRetry = viewModel::load) { home ->
                    HomeScreen(
                        home = home,
                        onPlaylistClick = { playlist ->
                            navController.navigate(Routes.playlist(playlist.id))
                        }
                    )
                }
            }
            composable(Routes.SEARCH) {
                val viewModel: SearchViewModel = viewModel()
                val results by viewModel.results.collectAsState()
                SearchScreen(
                    query = viewModel.query,
                    onQueryChange = viewModel::onQueryChange,
                    results = results,
                    onSongClick = { song ->
                        navController.navigate(Routes.song(song.id))
                    }
                )
            }
            composable(Routes.LIBRARY) {
                val viewModel: LibraryViewModel = viewModel()
                val state by viewModel.state.collectAsState()
                UiStateContent(state = state, onRetry = viewModel::load) { playlists ->
                    LibraryScreen(
                        playlists = playlists,
                        onPlaylistClick = { playlist ->
                            navController.navigate(Routes.playlist(playlist.id))
                        }
                    )
                }
            }
            composable(Routes.PLAYLIST) {
                val viewModel: PlaylistViewModel = viewModel()
                val state by viewModel.state.collectAsState()
                UiStateContent(state = state, onRetry = viewModel::load) { playlist ->
                    PlaylistScreen(
                        playlist = playlist,
                        onSongClick = { song ->
                            navController.navigate(Routes.song(song.id))
                        }
                    )
                }
            }
            composable(Routes.SONG) {
                val viewModel: SongViewModel = viewModel()
                val state by viewModel.state.collectAsState()
                UiStateContent(state = state, onRetry = viewModel::load) { song ->
                    SongScreen(song = song)
                }
            }
        }
    }
}

@Composable
fun BottomBar(navController: NavHostController) {
    val currentRoute = navController.currentBackStackEntryAsState().value?.destination?.route

    NavigationBar {
        NavigationBarItem(
            selected = currentRoute == Routes.HOME,
            onClick = {
                navController.navigate(Routes.HOME) {
                    popUpTo(Routes.HOME) { inclusive = true }
                }
            },
            icon = { Icon(Icons.Default.Home, contentDescription = null) },
            label = { Text("Home") }
        )
        NavigationBarItem(
            selected = currentRoute == Routes.SEARCH,
            onClick = {
                navController.navigate(Routes.SEARCH) {
                    popUpTo(Routes.HOME)
                }
            },
            icon = { Icon(Icons.Default.Search, contentDescription = null) },
            label = { Text("Search") }
        )
        NavigationBarItem(
            selected = currentRoute == Routes.LIBRARY,
            onClick = {
                navController.navigate(Routes.LIBRARY) {
                    popUpTo(Routes.HOME)
                }
            },
            icon = { Icon(Icons.Default.Menu, contentDescription = null) },
            label = { Text("Library") }
        )
    }
}