package org.example.domain.boundaries.financial.entities;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
@Getter
@Setter
@EqualsAndHashCode(of = "id")
public class InvoiceLine {

    @Id
    @GeneratedValue
    private long id;

    String description;

    double units;

    double pricePerUnit;

    double discountPercent;

    double total;

}
