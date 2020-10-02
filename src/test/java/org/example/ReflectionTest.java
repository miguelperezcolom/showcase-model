package org.example;

import io.mateu.util.SharedHelper;
import io.mateu.util.persistence.JPAHelper;
import org.example.application.population.Populator;
import org.example.domain.boundaries.educational.entities.AcademicPlan;
import org.example.domain.boundaries.educational.entities.Classroom;
import org.example.domain.boundaries.educational.entities.Teacher;
import org.junit.BeforeClass;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class ReflectionTest {

    @BeforeClass
    public static void init() throws Throwable {
        SharedHelper.loadProperties();
        Populator.populateAll();
    }

    @Test
    public void oneToOne() throws Throwable {

        JPAHelper.transact(em -> {

            Classroom c1a = JPAHelper.find(em, Classroom.class, "name", "1A");
            Teacher rafel = JPAHelper.find(em, Teacher.class, "name", "Rafel");
            Classroom c1b = JPAHelper.find(em, Classroom.class, "name", "1B");
            Teacher flor = JPAHelper.find(em, Teacher.class, "name", "Flor");

            assertEquals(c1a.getTutor(), flor);
            assertEquals(flor.getTutorOf(), c1a);
            assertEquals(rafel.getTutorOf(), c1b);
            assertEquals(c1b.getTutor(), rafel);
        });

    }

    @Test
    public void oneToMany() throws Throwable {

        JPAHelper.transact(em -> {

            AcademicPlan p = em.find(AcademicPlan.class, 1l);

            p.getCourses().forEach(c -> c.getSemesters().forEach(s -> {
                assertEquals(s.getCourse(), c);
            }));

        });

    }

}
