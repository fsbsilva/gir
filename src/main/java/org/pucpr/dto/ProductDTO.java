package org.pucpr.dto;

import lombok.Data;
import org.pucpr.domain.Company;
import org.pucpr.domain.Product;
import org.pucpr.domain.ProductItem;
import org.springframework.data.annotation.Id;

import java.util.Date;
import java.util.List;

@Data
public class ProductDTO {

    @Id
    private String id;
    private String name;
    private String category;
    private Company company;
    private List<ProductItem> items;

    public Product toProduct(){
        return Product.builder()
                .name(this.name)
                .category(this.category)
                .company(this.company)
                .items(this.items)
                .build();
    }
}
