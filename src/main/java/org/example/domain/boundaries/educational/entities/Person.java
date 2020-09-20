package org.example.domain.boundaries.educational.entities;

import lombok.MateuMDDEntity;

import java.time.LocalDate;
import java.time.temporal.ChronoUnit;

@MateuMDDEntity
public class Person {

    String name;

    LocalDate birthDate;

    public int getAge() {
        return (int) ChronoUnit.YEARS.between(birthDate, LocalDate.now());
    }

}
