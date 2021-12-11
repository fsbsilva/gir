package org.pucpr.dto;

import lombok.Data;
import org.springframework.data.annotation.Id;

import java.util.Date;

@Data
public class ProductItemDTO {

    @Id
    private String serialNumber;
    private Date dateEntry;
    private Date dateOut;
    private int project_id;

    public ProductItem toProductItem(){
        return ProductItem.builder()
                .serialNumber(this.serialNumber)
                .dateEntry(this.dateEntry)
                .dateOut(this.dateOut)
                .project_id(this.project_id)
                .build();
    }
}
