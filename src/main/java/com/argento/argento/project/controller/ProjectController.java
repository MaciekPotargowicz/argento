package com.argento.argento.project.controller;

import com.argento.argento.project.dto.ProjectDto;
import com.argento.argento.project.exception.NoElementFoundException;
import com.argento.argento.project.service.ProjectService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Slf4j
@RestController
@RequestMapping("/projects")
public class ProjectController {

    @Autowired
    private ProjectService projectService;

    @PostMapping(value = "/save", consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<String> saveProject(@RequestBody ProjectDto formProject) {
        log.info("save project:" + formProject);
        projectService.addProject(formProject);
        return new ResponseEntity<>(HttpStatus.CREATED);
    }

    @GetMapping("/all")
    public List<ProjectDto> showAll() {
        log.info("see all projects");
        return projectService.getAllProjects();
    }

    @GetMapping("/project")
    public ProjectDto getProjectByName(@RequestParam String name) throws NoElementFoundException {
        log.info("get project by name: [{}]", name);
        ProjectDto projectByName = projectService.getProjectByName(name);
        return projectByName;
    }

    @GetMapping(value = "/edit")
    public ProjectDto editProject(@RequestBody ProjectDto formProject) {
        log.info("edit project [{}]", formProject);
        return projectService.editProject(formProject);
    }

    @GetMapping("/delete")
    public ResponseEntity<String> deleteProject(@RequestParam(name = "name", required = true) String name) throws NoElementFoundException {
        log.info("delete project by name: [{}]", name);
        projectService.deleteProjectByName(name);
        return new ResponseEntity<>(HttpStatus.OK);
    }
}

