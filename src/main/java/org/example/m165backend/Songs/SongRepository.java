package org.example.m165backend.Songs;

import org.springframework.data.mongodb.repository.MongoRepository;

public interface SongRepository extends MongoRepository<Song, String> {
    // Zusätzliche Methoden für spezifische Abfragen, falls erforderlich
}
