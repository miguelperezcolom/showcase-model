package org.example;

import io.mateu.util.SharedHelper;
import io.mateu.util.persistence.JPAHelper;
import org.example.domain.boundaries.educational.entities.Course;
import org.example.domain.boundaries.educational.entities.Subject;
import org.example.domain.boundaries.educational.entities.Teacher;
import org.example.domain.boundaries.financial.entities.Address;
import org.example.domain.boundaries.financial.entities.FinancialAgent;
import org.junit.BeforeClass;
import org.junit.Test;

import java.util.Map;

import static org.junit.Assert.assertEquals;

public class JPATest {

    @BeforeClass
    public static void init() throws Throwable {
        SharedHelper.loadProperties();
    }

    @Test
    public void embedded() throws Throwable {

        JPAHelper.transact(em -> {

            FinancialAgent fa = new FinancialAgent();
            fa.setName("xxxxxxxx");
            Address a;
            fa.setAddress(a = new Address());
            a.setCity("aaaaaaaaaa");

            em.persist(fa);

            assertEquals(1, 1);
        });

    }

    @Test
    public void map() throws Throwable {

        Teacher t0 = new Teacher();
        t0.setName("aaaaaa");
        Teacher t1 = new Teacher();
        t1.setName("bbbbbbbb");

        Subject s0 = new Subject("xxxxx");
        Subject s1 = new Subject("yuyyyy");
        Subject s2 = new Subject("eiwuew");

        JPAHelper.transact(em -> em.persist(t0));
        JPAHelper.transact(em -> em.persist(t1));
        JPAHelper.transact(em -> em.persist(s0));
        JPAHelper.transact(em -> em.persist(s1));
        JPAHelper.transact(em -> em.persist(s2));

        Course c = new Course();
        c.setName("xxxxxxxx");

        JPAHelper.transact(em -> {

            c.setSubjectResponsibles(Map.of(s0, t0, s1, t0, s2, t1));

            em.persist(c);

        });

        JPAHelper.notransact(em -> {

            Map<Subject, Teacher> m = em.find(Course.class, c.getId()).getSubjectResponsibles();

            assertEquals(3, m.size());
            assertEquals(t0, m.get(s0));
            assertEquals(t0, m.get(s1));
            assertEquals(t1, m.get(s2));

        });

    }

}
