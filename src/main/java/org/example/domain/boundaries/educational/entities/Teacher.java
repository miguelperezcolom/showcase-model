package org.example.domain.boundaries.educational.entities;

import lombok.MateuMDDEntity;

import javax.persistence.OneToOne;

@MateuMDDEntity
public class Teacher extends Person {

    String title;

    @OneToOne(mappedBy = "tutor")
    Classroom tutorOf;

}
