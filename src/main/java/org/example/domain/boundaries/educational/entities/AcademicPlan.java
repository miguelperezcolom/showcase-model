package org.example.domain.boundaries.educational.entities;

import io.mateu.mdd.core.annotations.UseChips;
import lombok.MateuMDDEntity;

import javax.persistence.CascadeType;
import javax.persistence.OneToMany;
import java.util.List;
import java.util.Set;

@MateuMDDEntity
public class AcademicPlan {

    String name;

    @OneToMany(cascade = CascadeType.ALL)
    List<Subject> subjects;


    @OneToMany(cascade = CascadeType.ALL)
    Set<Course> courses;

    @UseChips
    @OneToMany
    Set<Teacher> teachers;

}
