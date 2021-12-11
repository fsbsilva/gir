package org.pucpr.controller;

import lombok.extern.slf4j.Slf4j;
import org.pucpr.domain.Product;
import org.pucpr.dto.ProductDTO;
import org.pucpr.service.ProductService;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@Slf4j
public class ProductController {
    private final ProductService service;

    public ProductController(ProductService service) {this.service = service;}

    @PostMapping("/product")
    public ResponseEntity addProject(@RequestBody ProductDTO dto) {
        log.info("Request : {}", dto);
        service.save(dto.toProduct());
        return ResponseEntity.status(HttpStatus.CREATED).build();
    }

    @PutMapping("/product/{id}")
    public ResponseEntity updateProject(@PathVariable("id") String id, @RequestBody ProductDTO dto ) {
        log.info("Request : {}", id);

        Optional<Product> data = service.findById(id);
        if ( data.isPresent() ) {
            Product product = data.get();
            product.setName(dto.getName());
            service.save(product);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }

        return ResponseEntity.status(HttpStatus.CREATED).build();
    }

    @GetMapping("/products")
    public List<Product> getAll() {
        return service.findAll();
    }
}

