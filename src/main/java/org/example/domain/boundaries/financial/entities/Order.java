package org.example.domain.boundaries.financial.entities;

import lombok.MateuMDDEntity;
import org.example.domain.boundaries.educational.entities.Person;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.util.List;

@MateuMDDEntity
public class Order {

    @NotNull
    @ManyToOne
    Person person; //todo: sustituir por id

    @OneToMany(cascade = CascadeType.ALL, orphanRemoval = true)
    List<OrderLine> lines;

    @NotNull
    @Enumerated(EnumType.STRING)
    OrderStatus status = OrderStatus.Pending;

}
