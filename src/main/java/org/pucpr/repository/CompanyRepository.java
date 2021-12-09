package org.pucpr.repository;

import org.pucpr.domain.Company;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Component;

@Component
public interface CompanyRepository extends MongoRepository<Company,String> {
}