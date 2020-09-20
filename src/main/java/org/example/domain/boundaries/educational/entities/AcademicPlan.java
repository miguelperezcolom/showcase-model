package org.example.domain.boundaries.educational.entities;

import lombok.MateuMDDEntity;

import javax.persistence.CascadeType;
import javax.persistence.OneToMany;
import java.util.List;

@MateuMDDEntity
public class AcademicPlan {

    String name;

    @OneToMany(cascade = CascadeType.ALL)
    List<Subject> subjects;

    @OneToMany(cascade = CascadeType.ALL)
    List<Course> courses;

}
