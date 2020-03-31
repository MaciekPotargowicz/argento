package com.argento.argento.project.entity;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.List;

@Entity
@Data
@NoArgsConstructor
@Table(name = "projects")
public class Project {


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_project")
    Long id;

    @Column(name = "project_name",unique = true, nullable = false)
    private String name;
    @Column(name = "client_name", nullable = false)
    private String clientName;
    @Column(name = "country", nullable = false)
    private String country;
    @Column(name = "status", nullable = false)
    private String status;
    @Column(name = "start_date", nullable = false)
    private LocalDate startDate;
    @Column(name = "end_date", nullable = false)
    private LocalDate endDate;

    @OneToMany(cascade=CascadeType.ALL,fetch = FetchType.LAZY)
    private List<Member> memberList;
}
