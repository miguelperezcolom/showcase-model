package org.example.domain.boundaries.educational.entities;

import lombok.MateuMDDEntity;

import javax.persistence.ManyToOne;

@MateuMDDEntity
public class Student {

    @ManyToOne
    Classroom classroom;

    boolean becado;

}
