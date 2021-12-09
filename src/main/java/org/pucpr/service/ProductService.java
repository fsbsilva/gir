package org.pucpr.service;

import org.pucpr.domain.Product;
import org.pucpr.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ProductService {

    @Autowired
    private final ProductRepository repository;

    public ProductService(ProductRepository repository) {
        this.repository = repository;
    }

    public Product save(Product domain) {
        return repository.save(domain);
    }

    public List<Product> findAll() {
        return repository.findAll();
    }

    public Optional<Product> findById(String id) {
        return repository.findById(id);
    }
}
