package org.pucpr.domain;

import lombok.Builder;
import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.List;

@Document
@Data
@Builder
public class Type {

    @Id
    private String id;
    private String name;
    private String category;
    private List<Product> products;
    private long totalIn;
    private long totalOut;
}
