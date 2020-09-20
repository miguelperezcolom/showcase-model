package org.example.domain.boundaries.educational.entities;

import lombok.MateuMDDEntity;

import javax.persistence.CascadeType;
import javax.persistence.OneToMany;
import java.util.List;

@MateuMDDEntity
public class Course {

    String name;

    @OneToMany(cascade = CascadeType.ALL)
    List<Semester> semesters;

    @OneToMany
    List<FinalGrade> finalGrades;

}
