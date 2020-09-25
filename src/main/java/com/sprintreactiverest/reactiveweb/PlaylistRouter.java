package com.sprintreactiverest.reactiveweb;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.MediaType;
import org.springframework.web.reactive.function.server.RequestPredicates;
import org.springframework.web.reactive.function.server.RouterFunction;
import org.springframework.web.reactive.function.server.RouterFunctions;
import org.springframework.web.reactive.function.server.ServerResponse;

//@Configuration
public class PlaylistRouter {

    //@Bean
    public RouterFunction<ServerResponse> route(PlayListHandler playListHandler) {
        return RouterFunctions
                .route(RequestPredicates.GET("/playlists").and(RequestPredicates.accept(MediaType.APPLICATION_JSON)), playListHandler::findAll)
                .andRoute(RequestPredicates.GET("/playlists/{id}").and(RequestPredicates.accept(MediaType.APPLICATION_JSON)), playListHandler::findById)
                .andRoute(RequestPredicates.POST("/playlists").and(RequestPredicates.accept(MediaType.APPLICATION_JSON)), playListHandler::save);
    }
}
