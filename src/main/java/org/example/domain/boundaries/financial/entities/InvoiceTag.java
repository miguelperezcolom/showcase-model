package org.example.domain.boundaries.financial.entities;

import lombok.MateuMDDEntity;

import javax.persistence.ManyToMany;
import java.util.List;

@MateuMDDEntity
public class InvoiceTag {

    String name;

    @ManyToMany
    List<Invoice> invoices;

}
