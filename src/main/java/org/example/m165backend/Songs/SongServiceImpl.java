package org.example.m165backend.Songs;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;

@Service
public class SongServiceImpl implements SongService {

    @Autowired
    private SongRepository songRepository;

    @Override
    public List<Song> getAllSongs() {
        return songRepository.findAll();
    }

    @Override
    public Song getSongById(String id) {
        Optional<Song> song = songRepository.findById(id);
        return song.orElse(null);
    }

    @Override
    public Song createSong(Song song) {
        return songRepository.save(song);
    }

    @Override
    public Song updateSong(String id, Song song) {
        Song existingSong = getSongById(id);
        if (existingSong != null) {
            existingSong.setTitle(song.getTitle());
            existingSong.setArtist(song.getArtist());
            existingSong.setDuration(song.getDuration());
            // Setze weitere Attribute entsprechend
            return songRepository.save(existingSong);
        }
        return null;
    }

    @Override
    public void deleteSong(String id) {
        songRepository.deleteById(id);
    }
}
