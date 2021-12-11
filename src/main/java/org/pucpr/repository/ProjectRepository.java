package org.pucpr.repository;

import org.pucpr.domain.Project;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Component;

@Component
public interface ProjectRepository extends MongoRepository<Project,String> {

    projectStock -> project -> type { name: OLT, [ { product: { company: Edcor },
                                                   { product: { company: Brodcom } ],
                                                       totalin: 10,
                                                   totalout: 5 ],
                                                       alert: { min, max }
                               type { name: ONU, [ { product: { company: Edcor },
                                                   { product: { company: Brodcom } ],
                                          totalin: 10, totalout: 5 ],
                                           alert: { min, max }

                                           adicionarProduct, retirarProduct
}