package org.example.domain.events;

import io.mateu.util.eventBus.Event;
import lombok.Getter;

@Getter
public class StudentGradedEvent implements Event {

    private final long gradeId;

    public StudentGradedEvent(long gradeId) {
        this.gradeId = gradeId;
    }
}
