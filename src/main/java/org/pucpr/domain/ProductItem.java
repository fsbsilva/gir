package org.pucpr.domain;

import lombok.Builder;
import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.Date;

@Document
@Data
@Builder
public class ProductItem {

    @Id
    private String serialNumber;
    private Date dateEntry;
    private Date dateOut;
    private int project_id;

}
