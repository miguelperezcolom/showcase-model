package org.example.domain.boundaries.educational.entities;

import lombok.MateuMDDEntity;

import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.ManyToOne;
import javax.validation.constraints.NotNull;

@MateuMDDEntity
public class Grade {

    @ManyToOne
    private Teacher teacher;

    @ManyToOne
    private Subject subject;

    @ManyToOne
    private Student student;

    @NotNull@Enumerated(EnumType.STRING)
    private GradeValue value;

}
