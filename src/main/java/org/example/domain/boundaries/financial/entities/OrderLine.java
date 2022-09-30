package org.example.domain.boundaries.financial.entities;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.validation.constraints.NotNull;

@Entity
@Getter
@Setter
@EqualsAndHashCode(of = "id")
public class OrderLine {

    @Id
    @GeneratedValue
    private long id;

    @ManyToOne
    final Order order;

    @NotNull
    @ManyToOne
    Item item;

    double units;

    double total;

    public OrderLine(Order order) {
        this.order = order;
    }

    public OrderLine() {
        this.order = null;
    }
}
