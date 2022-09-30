package org.example.domain.boundaries.maintenance.entities;

import io.mateu.mdd.shared.annotations.TextArea;
import io.mateu.mdd.shared.annotations.UseIdToSelect;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

@Entity
@Getter
@Setter
@EqualsAndHashCode(of = "id")
public class Issue {

    @Id
    @GeneratedValue
    private long id;

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
