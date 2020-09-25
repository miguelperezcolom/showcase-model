package org.example.domain.boundaries.financial;

import io.mateu.mdd.core.annotations.BoundaryListener;
import io.mateu.mdd.core.eventBus.EventBus;
import io.mateu.mdd.shared.BoundedContextListener;
import io.mateu.mdd.shared.Command;
import org.example.domain.boundaries.financial.logic.QuarterStartedEventConsumer;

import java.util.List;

@BoundaryListener
public class FinancialContextListener implements BoundedContextListener {
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
        return null;
    }

    @Override
    public void registerEventConsumers() {
        EventBus.register(new QuarterStartedEventConsumer());
    }
}
