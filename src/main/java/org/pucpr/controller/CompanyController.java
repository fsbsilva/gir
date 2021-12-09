package org.pucpr.controller;

import lombok.extern.slf4j.Slf4j;
import org.pucpr.domain.Company;
import org.pucpr.domain.Project;
import org.pucpr.dto.CompanyDTO;
import org.pucpr.dto.ProjectDTO;
import org.pucpr.service.CompanyService;
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
public class CompanyController {
    private final CompanyService service;

    public CompanyController(CompanyService service) {this.service = service;}

    @PostMapping("/company")
    public ResponseEntity addProject(@RequestBody CompanyDTO dto) {
        log.info("Request : {}", dto);
        service.save(dto.toCompany());
        return ResponseEntity.status(HttpStatus.CREATED).build();
    }

    @GetMapping("/companies")
    public List<Company> getAll() {
        return service.findAll();
    }
}

