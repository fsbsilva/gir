package org.pucpr.repository;

import org.pucpr.domain.Product;
import org.pucpr.domain.ProductItem;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Component;

@Component
public interface ProductItemRepository extends MongoRepository<ProductItem,String> {

}