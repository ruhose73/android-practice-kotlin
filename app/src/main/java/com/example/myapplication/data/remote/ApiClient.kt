package com.example.myapplication.data.remote
import kotlinx.serialization.json.Json
import okhttp3.MediaType.Companion.toMediaType
import retrofit2.Retrofit
import retrofit2.converter.kotlinx.serialization.asConverterFactory

object ApiClient {

    // Эмулятор + `adb reverse tcp:5000 tcp:5000`. Без adb reverse — "http://10.0.2.2:5000/"
    private const val BASE_URL = "http://localhost:5000/"

    private val json = Json { ignoreUnknownKeys = true }

    val api: MusicApi = Retrofit.Builder()
        .baseUrl(BASE_URL)
        .addConverterFactory(json.asConverterFactory("application/json".toMediaType()))
        .build()
        .create(MusicApi::class.java)
}