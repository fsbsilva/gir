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
    private String category;
    private Company company;
    private List<ProductItem> items;

}
