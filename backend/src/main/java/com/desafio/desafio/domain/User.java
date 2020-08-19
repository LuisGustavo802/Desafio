package com.desafio.desafio.domain;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Getter
@Setter
@Entity(name = "users")
@Table(name = "users")
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column
    private Long iduser;

    @Column
    private String username;

    @Column
    private String password;

    @Column
    private String accesslevel;
}
