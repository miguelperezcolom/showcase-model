package org.example.domain.boundaries.educational.entities;

import lombok.MateuMDDEntity;

import javax.persistence.ManyToOne;
import javax.validation.constraints.NotNull;

@MateuMDDEntity
public class FinalGrade {

    @NotNull
    @ManyToOne
    Course course;

}
