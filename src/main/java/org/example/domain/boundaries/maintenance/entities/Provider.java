package org.example.domain.boundaries.maintenance.entities;

import lombok.MateuMDDEntity;

import javax.validation.constraints.NotEmpty;

@MateuMDDEntity
public class Provider {

    @NotEmpty
    String name;

}
