package mk.ukim.finki.emt.tourmanagement.infrastructure;

import lombok.AllArgsConstructor;
import mk.ukim.finki.emt.sharedkernel.events.DomainEvent;
import mk.ukim.finki.emt.sharedkernel.infrastructure.DomainEventPublisher;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class DomainEventPublisherImpl implements DomainEventPublisher {

    private final KafkaTemplate<String, String> kafkaTemplate;

    @Override
    public void publish(DomainEvent event) {
        this.kafkaTemplate.send(event.topic(), event.toJson());
    }
}
