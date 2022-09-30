package org.example.domain.boundaries.maintenance.entities;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.validation.constraints.NotEmpty;

@Entity
@Getter
@Setter
@EqualsAndHashCode(of = "id")
public class Provider {

    @Id
    @GeneratedValue
    private long id;

    @NotEmpty
    String name;

}
