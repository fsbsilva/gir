package org.pucpr.controller;

import lombok.extern.slf4j.Slf4j;
import org.pucpr.domain.Project;
import org.pucpr.domain.ProjectStock;
import org.pucpr.dto.ProjectDTO;
import org.pucpr.dto.ProjectStockDTO;

import org.pucpr.service.ProjectStockService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.UUID;

@RestController
@Slf4j
public class ProjectStockController {
    private final ProjectStockService service;

    public ProjectStockController(ProjectStockService service) {this.service = service;}

    @PostMapping("/projectstock")
    public ResponseEntity addProject(@RequestBody ProjectStockDTO dto) {
        log.info("Request : {}", dto);
        UUID uudi = UUID.randomUUID();
        dto.getProject().setId(uudi.toString());
        service.save(dto.toProjectStock());
        return ResponseEntity.status(HttpStatus.CREATED).build();
    }

    @GetMapping("/projectstocks")
    public List<ProjectStock> getAll() {
        return service.findAll();
    }
}
