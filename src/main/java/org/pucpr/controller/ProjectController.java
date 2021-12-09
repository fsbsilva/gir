package org.pucpr.controller;

import lombok.extern.slf4j.Slf4j;
import org.pucpr.dto.ProjectDTO;
import org.pucpr.domain.Project;

import org.pucpr.service.ProjectService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@Slf4j
public class ProjectController {
    private final ProjectService projectService;

    public ProjectController(ProjectService projectService) {this.projectService = projectService;}

    @PostMapping("/project")
    public ResponseEntity addProject(@RequestBody ProjectDTO projectDTO) {
        log.info("Request : {}", projectDTO);
        projectService.save(projectDTO.toProject());
        return ResponseEntity.status(HttpStatus.CREATED).build();
    }

    @GetMapping("/projects")
    public List<Project> getAll() {
        return projectService.findAll();
    }
}

