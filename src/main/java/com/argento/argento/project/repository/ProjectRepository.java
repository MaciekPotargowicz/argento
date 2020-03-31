package com.argento.argento.project.repository;

import com.argento.argento.project.entity.Project;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface ProjectRepository extends JpaRepository<Project, Long> {

    Optional<Project> findProjectByNameIgnoreCase(String name);
    List<Project> findAll();
    List<Project> findProjectByStartDate(String startDate);
}
