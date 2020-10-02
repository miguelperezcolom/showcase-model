package org.example.domain.boundaries.educational.entities;

import io.mateu.mdd.shared.annotations.VisibleIf;
import lombok.MateuMDDEntity;
import org.example.domain.boundaries.common.entities.Person;

import javax.persistence.ManyToOne;

@MateuMDDEntity
public class Student extends Person {

    @ManyToOne
    Classroom classroom;

    boolean scholarshipped;

    @VisibleIf("$this.scholarshipped")
    String scholarship;

}
