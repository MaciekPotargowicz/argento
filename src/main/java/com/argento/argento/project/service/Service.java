package com.argento.argento.project.service;

import com.argento.argento.project.exception.NoElementFoundException;
import com.argento.argento.project.mapper.Mapper;
import com.argento.argento.project.dto.ProjectDto;
import com.argento.argento.project.entity.Project;
import com.argento.argento.project.repository.MemberRepository;
import com.argento.argento.project.repository.ProjectRepository;
import org.springframework.beans.factory.annotation.Autowired;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Optional;

@org.springframework.stereotype.Service
@Transactional
public class Service {

    @Autowired
    ProjectRepository projectRepository;

    @Autowired
    MemberRepository memberRepository;

    @Autowired
    Mapper mapper;

    public ProjectDto getProjectByName(String name) throws NoElementFoundException {
        Optional<Project> projectByNameIgnoreCase = projectRepository.findProjectByNameIgnoreCase(name);

        return projectRepository.findProjectByNameIgnoreCase(name).map(mapper::projectEntityToDto).
                orElseThrow(() -> new NoElementFoundException("Project not found"));
    }

    public List<Project> getAllProjects() {
        return projectRepository.findAll();
    }

    public List<Project> getProjectsByStartDate(String startDate) {
        return projectRepository.findProjectByStartDate(startDate);
    }

    public Project addProject(ProjectDto projectDto) {

        Project project = mapper.projectDtoToEntity(projectDto);
        return projectRepository.save(project);
    }

    public void deleteProject(String name) throws NoElementFoundException {

        ProjectDto projectByName = getProjectByName(name);
        projectRepository.delete(mapper.projectDtoToEntity(projectByName));
    }
}
