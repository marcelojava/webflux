package com.sprintreactiverest.reactiveweb.document;

import lombok.*;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class Playlist {

    @Id
    private String id;
    private String nome;
}
