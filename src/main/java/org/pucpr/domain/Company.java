package org.pucpr.domain;

import lombok.Builder;
import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document
@Data
@Builder
public class Company {
    @Id
    private String id;
    private String name;
    private String endereco;
    private String cep;
}
