package org.example.domain.boundaries.financial.entities;

import lombok.MateuMDDEntity;

@MateuMDDEntity
public class InvoiceLine {

    String description;

    double units;

    double pricePerUnit;

    double discountPercent;

    double total;

}
