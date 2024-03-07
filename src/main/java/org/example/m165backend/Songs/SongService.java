package org.example.m165backend.Songs;

import java.util.List;

public interface SongService {
    List<Song> getAllSongs();
    Song getSongById(String id);
    Song createSong(Song song);
    Song updateSong(String id, Song song);
    void deleteSong(String id);
}

