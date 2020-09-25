//package com.sprintreactiverest.reactiveweb;
//
//import com.sprintreactiverest.reactiveweb.document.Playlist;
//import com.sprintreactiverest.reactiveweb.repository.PlaylistRepository;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.boot.CommandLineRunner;
//import org.springframework.stereotype.Component;
//import reactor.core.publisher.Flux;
//
//import java.util.UUID;
//
//@Component
//public class DummyData implements CommandLineRunner {
//
//    @Autowired
//    private PlaylistRepository playlistRepository;
//
//    @Override
//    public void run(String... args) throws Exception {
//        this.playlistRepository.deleteAll()
//                .thenMany(
//                        Flux.just("playlist1", "playlist2", "playlist3", "playlist4", "playlist5", "playlist6",
//                                "playlist7", "playlist8")
//                        .map(nome -> new Playlist(UUID.randomUUID().toString(), nome))
//                        .flatMap(this.playlistRepository::save)
//                ).subscribe(System.out::println);
//    }
//}
