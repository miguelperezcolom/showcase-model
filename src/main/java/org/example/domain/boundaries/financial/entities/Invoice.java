package org.example.domain.boundaries.financial.entities;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.time.LocalDate;
import java.util.List;

@Entity
@Getter
@Setter
@EqualsAndHashCode(of = "id")
public class Invoice {

    @Id@GeneratedValue
    private long id;

    @NotNull
    @ManyToOne
    FinancialAgent recipient;

    LocalDate date;

    LocalDate dueDate;

    @OneToMany(cascade = CascadeType.ALL, orphanRemoval = true)
    List<InvoiceLine> lines;

    double total;

    boolean paid;

    @ManyToMany(mappedBy = "invoices")
    List<InvoiceTag> tags;

}
