package org.example.domain.boundaries.educational.logic;

import io.mateu.util.persistence.JPAHelper;
import org.example.domain.boundaries.educational.entities.Grade;
import org.example.domain.events.StudentGradedEvent;

import java.util.function.Consumer;

public class StudentGradedEventConsumer implements Consumer<StudentGradedEvent> {
    @Override
    public void accept(StudentGradedEvent studentGradedEvent) {
        System.out.println("student graded. grade id = " + studentGradedEvent.getGradeId());
        try {
            JPAHelper.transact(em -> {
                Grade g = em.find(Grade.class, studentGradedEvent.getGradeId());
                //todo: actualizar media
                //g.getStudent().
            });
        } catch (Throwable throwable) {
            throwable.printStackTrace();
        }
    }
}
