package org.example.domain.boundaries.educational.entities;

import io.mateu.mdd.core.annotations.WeekDays;
import lombok.MateuMDDEntity;
import org.example.domain.boundaries.common.entities.Person;

import javax.persistence.OneToOne;

@MateuMDDEntity
public class Teacher extends Person {

    String title;

    @OneToOne(mappedBy = "tutor")
    Classroom tutorOf;

    @WeekDays
    boolean[] officeDays;

}
