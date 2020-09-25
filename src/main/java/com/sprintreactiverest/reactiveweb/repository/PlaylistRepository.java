package com.sprintreactiverest.reactiveweb.repository;

import com.sprintreactiverest.reactiveweb.document.Playlist;
import org.springframework.data.mongodb.repository.ReactiveMongoRepository;

public interface PlaylistRepository extends ReactiveMongoRepository<Playlist, String> {
}
