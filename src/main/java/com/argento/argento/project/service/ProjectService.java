package com.argento.argento.project.service;

import com.argento.argento.project.entity.Questionnaire;
import com.argento.argento.project.exception.NoElementFoundException;
import com.argento.argento.project.mapper.BaseMapper;
import com.argento.argento.project.dto.ProjectDto;
import com.argento.argento.project.entity.Project;
import com.argento.argento.project.repository.MemberRepository;
import com.argento.argento.project.repository.ProjectRepository;
import com.argento.argento.project.repository.QuestionnaireRepository;
import org.springframework.beans.factory.annotation.Autowired;

import javax.transaction.Transactional;
import java.util.List;

@org.springframework.stereotype.Service
public class ProjectService {

    @Autowired
    private ProjectRepository projectRepository;

    @Autowired
    private MemberRepository memberRepository;



    @Autowired
    private BaseMapper mapper;

    @Transactional
    public ProjectDto editProject(ProjectDto projectDto){
        return mapper.mapProjectEntityToProjectDto(projectRepository.save(mapper.updateProject(projectDto)));
    }

    public List<ProjectDto> getAllProjects() {
        return mapper.mapProjectEntityListToProjectDtoList(projectRepository.findAll());
    }

    public List<Project> getProjectsByStartDate(String startDate) {
        return projectRepository.findProjectByStartDate(startDate);
    }

    public ProjectDto getProjectByName(String name) throws NoElementFoundException {
        return mapper.mapProjectEntityToProjectDto(projectRepository
                .findProjectByNameIgnoreCase(name)
                .orElseThrow(()->new NoElementFoundException("project not found")));
    }

    @Transactional
    public Project addProject(ProjectDto projectDto) {
        Project project = mapper.mapProjectDtoToProjectEntity(projectDto);
        return projectRepository.save(project);
    }

    public void deleteProjectByName(String name) throws NoElementFoundException {
        projectRepository.delete(projectRepository
                .findProjectByNameIgnoreCase(name).orElseThrow(()-> new NoElementFoundException("project not found")));
    }


}
