package com.ololo.demo.entety;

import lombok.*;
import org.springframework.data.annotation.Id;

import static lombok.AccessLevel.PRIVATE;

@NoArgsConstructor
@Getter
@Setter
@ToString
public class User {
    @Id
    @Setter(PRIVATE)
    private String id;

    private String externalId;
    private String login;
    private String pass;

    public User(String name, String surname, String externalId) {
        this.login = name;
        this.pass = surname;
        this.externalId = externalId;
    }

}
