package com.sprintreactiverest.reactiveweb;

import com.sprintreactiverest.reactiveweb.document.Playlist;
import com.sprintreactiverest.reactiveweb.service.PlaylistService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Component;
import org.springframework.web.reactive.function.server.ServerRequest;
import org.springframework.web.reactive.function.server.ServerResponse;
import reactor.core.publisher.Mono;

import static org.springframework.web.reactive.function.BodyInserters.fromPublisher;

//@Component
public class PlayListHandler {

    @Autowired
    private PlaylistService playlistService;


    public Mono<ServerResponse> findAll(ServerRequest serverRequest) {
        return ServerResponse.ok()
                .contentType(MediaType.APPLICATION_JSON)
                .body(this.playlistService.findAll(), Playlist.class);

    }

    public Mono<ServerResponse> findById(ServerRequest serverRequest) {
        String id = serverRequest.pathVariable("id");
        return ServerResponse.ok()
                .contentType(MediaType.APPLICATION_JSON)
                .body(this.playlistService.findById(id), Playlist.class);
    }

    public Mono<ServerResponse> save(ServerRequest serverRequest) {
        final Mono<Playlist> playlist = serverRequest.bodyToMono(Playlist.class);
        return ServerResponse.ok()
                .contentType(MediaType.APPLICATION_JSON)
                .body(fromPublisher(playlist.flatMap(this.playlistService::save), Playlist.class));
    }
}
