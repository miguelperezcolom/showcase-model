package org.example.domain.boundaries.maintenance.entities;

import io.mateu.mdd.shared.annotations.UseCheckboxes;
import io.mateu.mdd.shared.annotations.UseIdToSelect;
import io.mateu.mdd.shared.annotations.UseRadioButtons;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import javax.validation.constraints.NotEmpty;
import java.util.Set;

@Entity
@Getter
@Setter
@EqualsAndHashCode(of = "id")
@UseIdToSelect
public class Building {

    @Id
    @GeneratedValue
    private long id;

    @NotEmpty
    String name;

    @UseCheckboxes
    @OneToMany
    Set<Provider> preferredProviders;

    @UseRadioButtons
    @ManyToOne
    Technician assignedTechnician;

}
