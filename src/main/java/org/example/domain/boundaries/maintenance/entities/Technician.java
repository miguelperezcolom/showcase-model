package org.example.domain.boundaries.maintenance.entities;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;
import org.example.domain.boundaries.common.entities.Person;

import javax.persistence.Entity;

@Entity
@Getter
@Setter
@EqualsAndHashCode(of = "id")
public class Technician extends Person {
}
