package org.pucpr.repository;

import org.pucpr.domain.Type;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Component;

@Component
public interface TypeRepository extends MongoRepository<Type,String> {

}