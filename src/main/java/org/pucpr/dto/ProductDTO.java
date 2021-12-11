package org.pucpr.dto;

import lombok.Data;
import org.pucpr.domain.Company;
import org.pucpr.domain.Product;
import org.springframework.data.annotation.Id;

import java.util.List;

@Data
public class ProductDTO {

    @Id
    private String id;
    private String name;
    private String category;
    private Company company;

    public Product toProduct(){
        return Product.builder()
                .name(this.name)
                .company(this.company)
                .build();
    }
}
