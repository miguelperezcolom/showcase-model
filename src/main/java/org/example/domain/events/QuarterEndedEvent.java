package org.example.domain.events;

import io.mateu.util.eventBus.Event;
import lombok.Getter;

@Getter
public class QuarterEndedEvent implements Event {

    private final long quarterId;

    public QuarterEndedEvent(long quarterId) {
        this.quarterId = quarterId;
    }
}
