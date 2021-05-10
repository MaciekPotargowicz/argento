package com.argento.argento.project.entity;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@Table(name = "Question")
@NoArgsConstructor
@Data
public class Question {
    @Id
    @GeneratedValue()
    private Long id;

    @Column(name = "Question")
    private String question;
    @OneToOne(cascade=CascadeType.ALL,fetch = FetchType.LAZY)
    private Answer answer;
}
