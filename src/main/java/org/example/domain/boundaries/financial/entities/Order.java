package org.example.domain.boundaries.financial.entities;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;
import org.example.domain.boundaries.common.entities.Person;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.time.LocalDateTime;
import java.util.Date;
import java.util.List;

@Entity
@Getter
@Setter
@EqualsAndHashCode(of = "id")
@Table(name = "_order")
public class Order {

    @Id@GeneratedValue
    private long id;

    @NotNull
    @ManyToOne
    Person person; //todo: sustituir por id

    @NotNull
    Date requestDateTime;

    LocalDateTime delivered;

    @OneToMany(cascade = CascadeType.ALL, mappedBy = "order", orphanRemoval = true)
    List<OrderLine> lines;

    @NotNull
    @Enumerated(EnumType.STRING)
    OrderStatus status = OrderStatus.Pending;

}
