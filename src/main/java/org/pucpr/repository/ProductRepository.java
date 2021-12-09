package org.pucpr.repository;

import org.pucpr.domain.Product;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Component;

@Component
public interface ProductRepository extends MongoRepository<Product,String> {

}