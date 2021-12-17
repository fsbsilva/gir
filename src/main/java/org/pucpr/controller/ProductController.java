package org.pucpr.controller;

import lombok.extern.slf4j.Slf4j;
import org.pucpr.domain.Product;
import org.pucpr.domain.Type;
import org.pucpr.dto.ProductDTO;
import org.pucpr.repository.TypeRepository;
import org.pucpr.service.ProductService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@Slf4j
public class ProductController {
    private final ProductService service;
    private final TypeRepository typeRepository;

    public ProductController(ProductService service, TypeRepository typeRepository) {this.service = service;
        this.typeRepository = typeRepository;
    }

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

    @PutMapping("/product/{id}/add/{num}")
    public ResponseEntity addProduct(@PathVariable("id") String id,
                                     @PathVariable("num") String num  ) {
        log.info("Request : {}", id);

        Optional<Product> data = service.findById(id);
        Product product  = service.findById(id).orElseThrow( ()-> new RuntimeException());
        product.setTotalIn(product.getTotalIn() + Long.valueOf(num) );
        service.save(product);

        Type type = typeRepository.findById(product.getType_id()).orElseThrow( ()-> new RuntimeException());


        return ResponseEntity.status(HttpStatus.CREATED).build();
    }
}

