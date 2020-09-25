package org.example.domain.boundaries.financial.entities;

import lombok.MateuMDDEntity;

import javax.persistence.CascadeType;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.validation.constraints.NotNull;
import java.util.List;

@MateuMDDEntity
public class Invoice {

    @NotNull
    @ManyToOne
    FinancialAgent recipient;

    @OneToMany(cascade = CascadeType.ALL, orphanRemoval = true)
    List<InvoiceLine> lines;

    double total;

    @ManyToMany(mappedBy = "invoices")
    List<InvoiceTag> tags;

}
