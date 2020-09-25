package org.example.domain.boundaries.maintenance;

import io.mateu.mdd.shared.BoundedContextListener;
import io.mateu.mdd.shared.Command;

import java.util.List;

public class MaintenanceContextListener implements BoundedContextListener {
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

    }
}
