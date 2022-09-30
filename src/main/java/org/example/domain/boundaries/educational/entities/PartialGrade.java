package org.example.domain.boundaries.educational.entities;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.ManyToOne;
import javax.validation.constraints.NotNull;

@Entity
@Getter
@Setter
@EqualsAndHashCode(of = "id")
public class PartialGrade extends Grade {

    @NotNull
    @ManyToOne
    Semester semester;

}
