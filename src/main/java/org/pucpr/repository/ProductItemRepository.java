package org.pucpr.repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Component;

@Component
public interface ProductItemRepository extends MongoRepository<ProductItem,String> {

}