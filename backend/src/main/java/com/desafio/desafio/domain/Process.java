package com.desafio.desafio.domain;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Getter
@Setter
@Entity(name = "process")
@Table(name = "process")
public class Process {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column
    private Long idprocess;

    @Column
    private String description;
}