package com.desafio.desafio.domain;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Getter
@Setter
@Entity(name = "process_feedback")
@Table(name = "process_feedback")
public class FeedbackProcess {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column
    private Long id;

    @Column
    private Long iduser;

    @Column
    private Long idprocess;

    @Column
    private String feedback;

    @Column
    private String fgrevised;
}
