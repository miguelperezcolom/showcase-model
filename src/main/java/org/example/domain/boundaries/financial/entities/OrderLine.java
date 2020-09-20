package org.example.domain.boundaries.financial.entities;

import lombok.MateuMDDEntity;

import javax.persistence.ManyToOne;
import javax.validation.constraints.NotNull;

@MateuMDDEntity
public class OrderLine {

    @NotNull
    @ManyToOne
    Item item;

    double units;

    double total;
}
