package org.example.domain.boundaries.financial.logic;

import io.mateu.util.persistence.JPAHelper;
import org.example.domain.events.QuarterEndedEvent;

import java.util.function.Consumer;

public class QuarterEndedEventConsumer implements Consumer<QuarterEndedEvent> {
    @Override
    public void accept(QuarterEndedEvent event) {
        try {
            JPAHelper.transact(em -> {
                //todo: facturar pedidos
            });
        } catch (Throwable throwable) {
            throwable.printStackTrace();
        }

    }
}
