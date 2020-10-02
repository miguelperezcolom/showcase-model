package org.example.domain.boundaries.maintenance.entities;

import io.mateu.mdd.shared.annotations.TextArea;
import io.mateu.mdd.shared.annotations.UseIdToSelect;
import lombok.MateuMDDEntity;

import javax.persistence.ManyToOne;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

@MateuMDDEntity
public class Issue {

    @ManyToOne@NotNull
    Building building;

    public void setBuilding(Building building) {
        this.building = building;
        if (building != null && technician == null) technician = building.getAssignedTechnician();
    }

    @ManyToOne@NotNull
    Technician technician;

    @NotEmpty
    String description;

    boolean done;

    @TextArea
    String comments;
}
