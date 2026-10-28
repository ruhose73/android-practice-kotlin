package com.example.myapplication.data.remote

import com.example.myapplication.domain.HomeData
import com.example.myapplication.domain.Playlist
import com.example.myapplication.domain.Song
import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.Query

interface MusicApi {
    @GET("api/home")
    suspend fun getHome(): HomeData

    @GET("api/library")
    suspend fun getLibrary(): List<Playlist>

    @GET("api/playlists/{id}")
    suspend fun getPlaylist(@Path("id") id: String): Playlist

    @GET("api/songs")
    suspend fun searchSongs(@Query("q") query: String): List<Song>

    @GET("api/songs/{id}")
    suspend fun getSong(@Path("id") id: String): Song
}