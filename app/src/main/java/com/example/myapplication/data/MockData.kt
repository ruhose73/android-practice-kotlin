package com.example.myapplication.data

import com.example.myapplication.domain.Playlist
import com.example.myapplication.domain.Song


object MockData {

    val songs: List<Song> = listOf(
        Song("1", "Bohemian Rhapsody", "Queen", "5:55", 0xFF6A1B9A),
        Song("2", "Imagine", "John Lennon", "3:07", 0xFF283593),
        Song("3", "Hotel California", "Eagles", "6:30", 0xFF00838F),
        Song("4", "Stairway to Heaven", "Led Zeppelin", "8:02", 0xFF2E7D32),
        Song("5", "Smells Like Teen Spirit", "Nirvana", "5:01", 0xFFC62828),
        Song("6", "Billie Jean", "Michael Jackson", "4:54", 0xFFEF6C00),
        Song("7", "Like a Rolling Stone", "Bob Dylan", "6:13", 0xFF4E342E),
        Song("8", "Hey Jude", "The Beatles", "7:11", 0xFF37474F)
    )

    val madeForYou: List<Playlist> = listOf(
        Playlist("m1", "Daily Mix 1", "Queen, Nirvana, Eagles", 0xFF6A1B9A, songs.take(4)),
        Playlist("m2", "Daily Mix 2", "The Beatles, Bob Dylan", 0xFF283593, songs.takeLast(4)),
        Playlist("m3", "Discover Weekly", "Новое для вас", 0xFF00838F, songs.shuffled()),
        Playlist("m4", "Release Radar", "Свежие релизы", 0xFF2E7D32, songs.take(3))
    )

    val popular: List<Playlist> = listOf(
        Playlist("p1", "Top 50 Global", "Обновляется ежедневно", 0xFFC62828),
        Playlist("p2", "Happy New Year", "Праздничное настроение", 0xFFEF6C00),
        Playlist("p3", "Chill Hits", "Расслабься", 0xFF4E342E),
        Playlist("p4", "Rock Classics", "Вечная классика", 0xFF37474F)
    )

    val mood: List<Playlist> = listOf(
        Playlist("d1", "Workout", "Энергия", 0xFFD32F2F),
        Playlist("d2", "Focus", "Для работы", 0xFF1976D2),
        Playlist("d3", "Sleep", "Спокойной ночи", 0xFF512DA8),
        Playlist("d4", "Party", "Танцуй", 0xFFF57C00)
    )

    val library: List<Playlist> = listOf(
        Playlist("l1", "Liked Songs", "42 трека", 0xFF9C27B0, songs),
        Playlist("l2", "Мои плейлисты", "5 плейлистов", 0xFF3F51B5),
        Playlist("l3", "Скачанные", "12 треков", 0xFF009688),
        Playlist("l4", "История", "Недавно слушали", 0xFF795548)
    )
}