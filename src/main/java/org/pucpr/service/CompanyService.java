package org.pucpr.service;

import org.pucpr.domain.Company;
import org.pucpr.repository.CompanyRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CompanyService {
    @Autowired
    private final CompanyRepository repository;

    public CompanyService(CompanyRepository repository) {
        this.repository = repository;
    }

    public Company save(Company domain) {
        return repository.save(domain);
    }

    public List<Company> findAll() {
        return repository.findAll();
    }
}
