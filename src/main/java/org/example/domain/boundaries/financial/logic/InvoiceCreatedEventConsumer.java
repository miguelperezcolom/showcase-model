package org.example.domain.boundaries.financial.logic;

import io.mateu.util.persistence.JPAHelper;
import org.example.domain.events.InvoiceCreatedEvent;

import java.util.function.Consumer;

public class InvoiceCreatedEventConsumer implements Consumer<InvoiceCreatedEvent> {
    @Override
    public void accept(InvoiceCreatedEvent event) {
        try {
            JPAHelper.transact(em -> {
                //todo: generar pedidos
            });
        } catch (Throwable throwable) {
            throwable.printStackTrace();
        }

    }
}
