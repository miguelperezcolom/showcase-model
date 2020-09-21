package org.example.domain.boundaries.educational.entities;

import lombok.MateuMDDEntity;

import javax.persistence.ManyToOne;

@MateuMDDEntity
public class Student extends Person {

    @ManyToOne
    Classroom classroom;

    boolean scholarshipped;

}
