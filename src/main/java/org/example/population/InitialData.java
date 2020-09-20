package org.example.population;

import lombok.Getter;
import lombok.Setter;
import org.example.domain.boundaries.educational.entities.*;

import javax.persistence.EntityManager;
import java.util.List;

@Getter@Setter
public class InitialData {

    List<AcademicPlan> plans;

    List<Semester> semesters;

    List<Teacher> teachers;

    List<Student> students;

    List<Classroom> classrooms;

    List<Grade> grades;


    public void persistAll(EntityManager em) throws Throwable {

        if (plans != null) plans.stream().forEach(p -> em.persist(p));

    }

}
