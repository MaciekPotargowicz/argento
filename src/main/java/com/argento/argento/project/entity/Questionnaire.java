package com.argento.argento.project.entity;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.List;

@Entity
@Data
@Table(name = "Questionnaire")
@NoArgsConstructor
public class Questionnaire {

    @Id
    @GeneratedValue()
    private Long id;

    @OneToMany(cascade=CascadeType.ALL,fetch = FetchType.LAZY)
    private List<Question> questionList;


}
