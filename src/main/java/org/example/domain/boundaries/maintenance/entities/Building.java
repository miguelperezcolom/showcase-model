package org.example.domain.boundaries.maintenance.entities;

import io.mateu.mdd.core.annotations.UseCheckboxes;
import io.mateu.mdd.core.annotations.UseIdToSelect;
import io.mateu.mdd.core.annotations.UseRadioButtons;
import lombok.MateuMDDEntity;

import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.validation.constraints.NotEmpty;
import java.util.Set;

@MateuMDDEntity@UseIdToSelect
public class Building {

    @NotEmpty
    String name;

    @UseCheckboxes
    @OneToMany
    Set<Provider> preferredProviders;

    @UseRadioButtons
    @ManyToOne
    Technician assignedTechnician;

}
