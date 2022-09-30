package org.example.domain.boundaries.educational.entities;

import io.mateu.mdd.shared.annotations.WeekDays;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;
import org.example.domain.boundaries.common.entities.Person;

import javax.persistence.*;

@Entity
@Getter
@Setter
@EqualsAndHashCode(of = "id")
public class Teacher extends Person {

    @Id
    @GeneratedValue
    private long id;

    String title;

    @OneToOne(mappedBy = "tutor")
    Classroom tutorOf;

    /*
    @WeekDays
    boolean[] officeDays;
     */

}
