package org.pucpr.controller;

import lombok.extern.slf4j.Slf4j;
import org.pucpr.domain.Product;
import org.pucpr.domain.ProductItem;
import org.pucpr.dto.ProductDTO;
import org.pucpr.dto.ProductItemDTO;
import org.pucpr.service.ProductItemService;
import org.pucpr.service.ProductService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@RestController
@Slf4j
public class ProductItemController {
    private final ProductService service;

    public ProductItemController(ProductService service) {this.service = service;}

    @PostMapping("/product/{id}/item")
    public ResponseEntity addItem(@PathVariable("id") String id, @RequestBody ProductItemDTO dto) {
        log.info("Request : {}", dto);

        Optional<Product> data = service.findById(id);
        if ( data.isPresent() ) {
            Product product = data.get();
            List<ProductItem> list = product.getItems();
            if ( list != null ){
                list.add(dto.toProductItem());
            } else {
                list = new ArrayList<ProductItem>();
                list.add(dto.toProductItem());
                product.setItems(list);
            }
            service.save(product);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }

        return ResponseEntity.status(HttpStatus.CREATED).build();
    }

    @GetMapping("/product/{id}/items")
    public List<ProductItem> getAll(@PathVariable("id") String id) {
        log.info("Request : {}");

        Optional<Product> data = service.findById(id);
        if ( data.isPresent() ) {
            Product product = data.get();
            return product.getItems();
        } else {
            return new ArrayList<ProductItem>();
        }

    }
}

