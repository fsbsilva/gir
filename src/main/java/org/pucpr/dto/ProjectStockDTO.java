package org.pucpr.dto;

import lombok.Data;
import org.pucpr.domain.Project;
import org.pucpr.domain.ProjectStock;

@Data
public class ProjectStockDTO {

    private String id;
    private Project project;

    public ProjectStock toProjectStock() {
        return ProjectStock.builder().project(this.project).build();
    }
}
