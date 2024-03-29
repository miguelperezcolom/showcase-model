package org.example.domain.boundaries.educational.entities;

import io.mateu.mdd.shared.annotations.*;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;
import org.example.domain.boundaries.common.entities.Person;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.validation.constraints.NotNull;

@Entity
@Getter
@Setter
@EqualsAndHashCode(of = "id")
public class Student extends Person {

    @Id
    @GeneratedValue
    private long id;

    @ManyToOne
    Classroom classroom;

    boolean scholarshipped;

    @VisibleIf("$this.scholarshipped")
    String scholarship;

    @NotNull
    GradeValue averageGrade = GradeValue.N;

    public void setAverageGrade(GradeValue averageGrade) {
        this.averageGrade = averageGrade;

        if (GradeValue.A.equals(averageGrade) || GradeValue.B.equals(averageGrade)) {
            classification = "Excellent!";
            css = "mdd-green-bgd";
        } else if (GradeValue.C.equals(averageGrade)) {
            classification = "Not so good";
            css = "mdd-orange-bgd";
        } else {
            classification = "Could improve";
            css = "mdd-red-bgd";
        }



    }

    @Ignored
    transient String css;

    @Css("$this.css")
    transient String classification = "Unknown";


    @EnabledIf("$this.classification == 'Could improve'")
    @TextArea
    String commentOnClassification;

}
