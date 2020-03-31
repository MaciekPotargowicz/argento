package com.argento.argento.project.controller;

import com.argento.argento.project.dto.ProjectDto;
import com.argento.argento.project.entity.Member;
import com.argento.argento.project.exception.NoElementFoundException;
import com.argento.argento.project.service.Service;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Slf4j
@Controller
@RequestMapping("/projects")
public class HomeController {

    @Autowired
    Service service;

    @GetMapping("/")
    public String home() {
        return "index";
    }

    @PostMapping("/save")
    public String saveProject(@ModelAttribute ProjectDto formProject, Model model) {
        log.info("save project:" + formProject);
        service.addProject(formProject);
        return "redirect:/projects/all";
    }

    @GetMapping("/all")
    public String showAll(Model model) {
        log.info("see all projects");
        model.addAttribute("projects", service.getAllProjects());
        return "allProjects";
    }

    @GetMapping("/create")
    public String showCreateForm(Model model) {
        log.info("create project");

        ProjectDto projectDtoForm = new ProjectDto();
        for (int i = 1; i <= 3; i++) {
            projectDtoForm.addMember(new Member());
        }

        model.addAttribute("formMember", projectDtoForm);
        model.addAttribute("formProject", projectDtoForm);
        return "addProject";
    }

    @GetMapping(value = "/search")
    public String searchProjectByName() {
        log.info("search project");
        return "searchProject";
    }

    @GetMapping(value = "/edit")
    public String editProject(@RequestParam(name = "name", required = true) String name, Model model) {
        log.info("edit project");
        try {
            ProjectDto projectByName = service.getProjectByName(name);
            model.addAttribute("formFoundedProject", projectByName);
        } catch (NoElementFoundException e) {
            e.getMessage("Project not Found");
            return "errorPage";
        }
        return "editProject";
    }

    @GetMapping("/delete")
    public String deleteProject(@RequestParam(name = "name", required = true) String name) {
        log.info("delete project");
        try {
            service.deleteProject(name);
        } catch (NoElementFoundException e) {
            e.getMessage("Project not found");
            return "errorPage";
        }
        return "redirect:/projects/all";
    }
}

