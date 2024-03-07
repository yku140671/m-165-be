package org.example.m165backend.Songs;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/songs")
public class SongController {

    @Autowired
    private SongService songService;

    @GetMapping
    public ResponseEntity<List<Song>> getAllSongs() {
        List<Song> songs = songService.getAllSongs();
        return new ResponseEntity<>(songs, HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Song> getSongById(@PathVariable String id) {
        Song song = songService.getSongById(id);
        if (song != null) {
            return new ResponseEntity<>(song, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @PostMapping
    public ResponseEntity<Song> createSong(@RequestBody Song song) {
        Song createdSong = songService.createSong(song);
        return new ResponseEntity<>(createdSong, HttpStatus.CREATED);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Song> updateSong(@PathVariable String id, @RequestBody Song song) {
        Song updatedSong = songService.updateSong(id, song);
        if (updatedSong != null) {
            return new ResponseEntity<>(updatedSong, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteSong(@PathVariable String id) {
        songService.deleteSong(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}

