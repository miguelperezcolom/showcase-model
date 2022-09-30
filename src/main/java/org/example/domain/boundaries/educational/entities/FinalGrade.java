package org.example.domain.boundaries.educational.entities;


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
public class FinalGrade extends Grade {

    @Id
    @GeneratedValue
    private long id;

    @NotNull
    @ManyToOne
    Course course;

}
