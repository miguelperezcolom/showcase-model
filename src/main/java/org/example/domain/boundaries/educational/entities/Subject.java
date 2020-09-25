package org.example.domain.boundaries.educational.entities;

import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;
import io.mateu.mdd.core.annotations.TextArea;
import lombok.MateuMDDEntity;

@MateuMDDEntity
@JsonIdentityInfo(generator = ObjectIdGenerators.StringIdGenerator.class, property = "@id")
public class Subject {

    String name;

    @TextArea
    String[] aliases;

    int[] validAges;

    public Subject(String name) {
        this.name = name;
    }
}
