package com.argento.argento.project.entity;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@Table(name = "Answer")
@NoArgsConstructor
@Data
public class Answer {

    @Id
    @GeneratedValue()
    Long id;

    @Column(name = "Answer")
    private String answer;
}
