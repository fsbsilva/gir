package org.pucpr.dto;

import lombok.Data;
import org.pucpr.domain.Project;

@Data
public class ProjectDTO {
    private String name;

    public Project toProject(){
        return Project.builder().name(this.name).build();
    }
}
