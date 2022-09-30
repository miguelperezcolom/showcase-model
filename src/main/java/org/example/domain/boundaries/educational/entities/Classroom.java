package org.example.domain.boundaries.educational.entities;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.List;

@Entity
@Getter
@Setter
@EqualsAndHashCode(of = "id")
public class Classroom {

    @Id
    @GeneratedValue
    private long id;

    String name;

    @OneToOne
    Teacher tutor;

    int capacity;

    Double maximumAllowedRatio;

    @OneToMany(mappedBy = "classroom")
    List<Student> students;
}
