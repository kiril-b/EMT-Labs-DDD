package mk.ukim.finki.emt.sharedkernel.infrastructure;

import mk.ukim.finki.emt.sharedkernel.events.DomainEvent;

public interface DomainEventPublisher {

    void publish(DomainEvent event);

}
