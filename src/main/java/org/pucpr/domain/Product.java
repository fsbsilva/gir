package org.pucpr.domain;

import lombok.Builder;
import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.Date;
import java.util.List;

@Document
@Data
@Builder
public class Product {

    @Id
    private String id;
    private String name;
    private Company company;
    private long totalIn;
    private long totalOut;
    private String type_id;

}
