package org.example.domain.boundaries.educational.entities;

import lombok.MateuMDDEntity;

import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import java.util.List;

@MateuMDDEntity
public class Classroom {

    String name;

    @OneToOne
    Teacher tutor;

    int capacity;

    Double maximumAllowedRatio;

    @OneToMany(mappedBy = "classroom")
    List<Student> students;
}
