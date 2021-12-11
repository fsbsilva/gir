package org.pucpr.repository;

import org.pucpr.domain.Project;
import org.pucpr.domain.ProjectStock;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Component;

@Component
public interface ProjectStockRepository extends MongoRepository<ProjectStock,String> {


}
