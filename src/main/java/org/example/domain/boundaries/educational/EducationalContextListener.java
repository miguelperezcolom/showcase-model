package org.example.domain.boundaries.educational;

import io.mateu.mdd.core.annotations.BoundaryListener;
import io.mateu.mdd.shared.BoundedContextListener;
import io.mateu.mdd.shared.Command;
import io.mateu.util.eventBus.EventBus;
import org.example.domain.boundaries.educational.logic.StartCourseCommand;
import org.example.domain.boundaries.educational.logic.StudentGradedEventConsumer;

import java.util.List;

@BoundaryListener
public class EducationalContextListener implements BoundedContextListener {
    @Override
    public void init() {

    }

    @Override
    public void contextInitialized() {

    }

    @Override
    public void contextDestroyed() {

    }

    @Override
    public List<Command> getCommands() {
        return List.of(new StartCourseCommand());
    }

    @Override
    public void registerEventConsumers() {

        EventBus.register(new StudentGradedEventConsumer());

    }
}
