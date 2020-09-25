package com.sprintreactiverest.reactiveweb.controller;

import com.sprintreactiverest.reactiveweb.document.Playlist;
import com.sprintreactiverest.reactiveweb.service.PlaylistService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;
import reactor.util.function.Tuple2;

import java.time.Duration;

@RestController
@RequestMapping("/playlists")
public class PlaylistController {

    @Autowired
    private PlaylistService playlistService;

    @GetMapping
    public Flux<Playlist> findAll() {
        return this.playlistService.findAll();
    }

    @GetMapping(value = "/{id}")
    public Mono<Playlist> findAll(@PathVariable String id) {
        return this.playlistService.findById(id);
    }

    @PostMapping
    public Mono<Playlist> findAll(@RequestBody Playlist playlist) {
        return this.playlistService.save(playlist);
    }

    @GetMapping(value = "/events", produces = MediaType.TEXT_EVENT_STREAM_VALUE)
    public Flux<Tuple2<Long, Playlist>> events() {
        Flux<Long> interval = Flux.interval(Duration.ofSeconds(10));
        Flux<Playlist> events = this.playlistService.findAll();
        return Flux.zip(interval, events);
    }
}
