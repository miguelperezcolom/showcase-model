package org.example.domain.boundaries.educational.entities;

import io.mateu.mdd.shared.annotations.UseChips;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.List;
import java.util.Set;

@Entity
@Getter
@Setter
@EqualsAndHashCode(of = "id")
public class AcademicPlan {

    @Id
    @GeneratedValue
    private long id;

    String name;

    @OneToMany(cascade = CascadeType.ALL)
    List<Subject> subjects;


    @OneToMany(cascade = CascadeType.ALL)
    Set<Course> courses;

    @UseChips
    @OneToMany
    Set<Teacher> teachers;

}
