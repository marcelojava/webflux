package com.sprintreactiverest.reactiveweb.service;

import com.sprintreactiverest.reactiveweb.document.Playlist;
import com.sprintreactiverest.reactiveweb.repository.PlaylistRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Service
public class PlaylistService {

    @Autowired
    private PlaylistRepository playlistRepository;

    public Flux<Playlist> findAll(){
        return this.playlistRepository.findAll();
    }

    public Mono<Playlist> findById(String id){
        return this.playlistRepository.findById(id);
    }

    public Mono<Playlist> save(Playlist playlist){
        return this.playlistRepository.save(playlist);
    }
}
