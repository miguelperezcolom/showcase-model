package org.example.domain.boundaries.educational.entities;

import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;
import io.mateu.mdd.shared.annotations.TextArea;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.ElementCollection;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
@Getter
@Setter
@EqualsAndHashCode(of = "id")
@JsonIdentityInfo(generator = ObjectIdGenerators.StringIdGenerator.class, property = "@id")
public class Subject {

    @Id
    @GeneratedValue
    private long id;

    String name;

    @TextArea
    String[] aliases;

    int[] validAges;

    public Subject(String name) {
        this.name = name;
    }

    public Subject() {

    }
}
