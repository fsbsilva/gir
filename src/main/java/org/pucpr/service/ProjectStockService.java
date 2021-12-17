package org.pucpr.service;

import org.pucpr.domain.Product;
import org.pucpr.domain.Project;
import org.pucpr.domain.ProjectStock;
import org.pucpr.repository.ProjectRepository;
import org.pucpr.repository.ProjectStockRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ProjectStockService {

    @Autowired
    private final ProjectStockRepository repository;

    public ProjectStockService(ProjectStockRepository repository) {
        this.repository = repository;
    }

    public ProjectStock save(ProjectStock domain) {
        return repository.save(domain);
    }

    public List<ProjectStock> findAll() {
        return repository.findAll();
    }

    public Optional<ProjectStock> findById(String id) {
        return repository.findById(id);
    }

}
