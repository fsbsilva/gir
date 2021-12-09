package org.pucpr.dto;

import lombok.Data;
import org.pucpr.domain.Company;

@Data
public class CompanyDTO {
    private String name;

    public Company toCompany(){
        return Company.builder().name(this.name).build();
    }
}
