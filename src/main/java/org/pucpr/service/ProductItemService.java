package org.pucpr.service;

import org.pucpr.repository.ProductItemRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ProductItemService {

    @Autowired
    private final ProductItemRepository repository;

    public ProductItemService(ProductItemRepository repository) {
        this.repository = repository;
    }

    public ProductItem save(ProductItem domain) {
        return repository.save(domain);
    }

    public List<ProductItem> findAll() {
        return repository.findAll();
    }

    public Optional<ProductItem> findById(String id) {
        return repository.findById(id);
    }
}
