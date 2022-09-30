package org.example.domain.boundaries.educational.entities;

import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

@Entity
@Getter
@Setter
@EqualsAndHashCode(of = "id")
@JsonIdentityInfo(generator = ObjectIdGenerators.StringIdGenerator.class, property = "@id")
public class Semester {

    @Id
    @GeneratedValue
    private long id;

    @ManyToOne
    Course course;

    String name;

    public Semester(String name) {
        this.name = name;
    }

    public Semester() {

    }
}
