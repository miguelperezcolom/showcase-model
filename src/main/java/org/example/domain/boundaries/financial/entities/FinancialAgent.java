package org.example.domain.boundaries.financial.entities;

import lombok.MateuMDDEntity;

import javax.persistence.Embedded;
import javax.validation.constraints.NotEmpty;

@MateuMDDEntity
public class FinancialAgent {

    @NotEmpty
    String name;

    @Embedded
    Address address;

}
