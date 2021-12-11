package org.pucpr.repository;

import org.pucpr.domain.Project;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Component;

@Component
public interface ProjectRepository extends MongoRepository<Project,String> {

}