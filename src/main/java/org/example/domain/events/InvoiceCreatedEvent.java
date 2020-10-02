package org.example.domain.events;

import io.mateu.util.eventBus.Event;
import lombok.Getter;

@Getter
public class InvoiceCreatedEvent implements Event {

    private final long invoiceId;

    public InvoiceCreatedEvent(long invoiceId) {
        this.invoiceId = invoiceId;
    }
}
