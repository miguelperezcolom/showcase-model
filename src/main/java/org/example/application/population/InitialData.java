package org.example.application.population;

import lombok.Getter;
import lombok.Setter;
import org.example.domain.boundaries.educational.entities.*;
import org.example.domain.boundaries.financial.entities.Invoice;
import org.example.domain.boundaries.financial.entities.InvoiceTag;
import org.example.domain.boundaries.financial.entities.Order;
import org.example.domain.boundaries.maintenance.entities.Building;
import org.example.domain.boundaries.maintenance.entities.Provider;
import org.example.domain.boundaries.maintenance.entities.Technician;

import javax.persistence.EntityManager;
import java.util.List;

@Getter@Setter
public class InitialData {

    List<AcademicPlan> plans;

    List<Semester> semesters;

    List<Subject> subjects;

    List<Teacher> teachers;

    List<Student> students;

    List<Classroom> classrooms;

    List<PartialGrade> partials;

    List<FinalGrade> finals;

    List<Order> orders;

    List<Invoice> invoices;

    List<InvoiceTag> invoiceTags;


    List<Building> buildings;
    List<Provider> providers;
    List<Technician> technicians;


    public void persistAll(EntityManager em) throws Throwable {

        reverseMapAll();

        persistAll(em, plans);
        persistAll(em, semesters);
        persistAll(em, subjects);
        persistAll(em, teachers);
        persistAll(em, students);
        persistAll(em, classrooms);
        persistAll(em, partials);
        persistAll(em, finals);
        persistAll(em, orders);
        persistAll(em, invoices);
        persistAll(em, invoiceTags);

        persistAll(em, buildings);
        persistAll(em, providers);
        persistAll(em, technicians);
    }

    private void reverseMapAll() {
        if (classrooms != null) classrooms.forEach(c -> {
            if (c.getTutor() != null) c.getTutor().setTutorOf(c);
            c.getStudents().forEach(s -> s.setClassroom(c));
        });
        if (plans != null) plans.forEach(p -> p.getCourses().forEach(c -> c.getSemesters().forEach(s -> s.setCourse(c))));

    }

    private void persistAll(EntityManager em, List l) {
        if (l != null) l.stream().forEach(p -> em.persist(p));
    }

}
