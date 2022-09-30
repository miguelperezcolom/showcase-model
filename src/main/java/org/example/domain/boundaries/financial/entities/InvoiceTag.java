package org.example.domain.boundaries.financial.entities;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import java.util.List;

@Entity
@Getter@Setter@EqualsAndHashCode(of = "id")
public class InvoiceTag {

    @Id@GeneratedValue
    private long id;

    String name;

    @ManyToMany
    List<Invoice> invoices;

}
