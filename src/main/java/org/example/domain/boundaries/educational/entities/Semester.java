package org.example.domain.boundaries.educational.entities;

import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;
import lombok.MateuMDDEntity;

import javax.persistence.ManyToOne;

@MateuMDDEntity
@JsonIdentityInfo(generator = ObjectIdGenerators.StringIdGenerator.class, property = "@id")
public class Semester {

    @ManyToOne
    Course course;

    String name;

    public Semester(String name) {
        this.name = name;
    }
}
