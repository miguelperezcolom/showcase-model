package org.example.domain.boundaries.financial.entities;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
@Getter
@Setter
@EqualsAndHashCode(of = "code")
public class Item {

    @Id
    String code;

    String description;

    double price;

}
