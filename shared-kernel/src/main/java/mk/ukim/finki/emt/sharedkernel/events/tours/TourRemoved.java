package mk.ukim.finki.emt.sharedkernel.events.tours;

import lombok.Getter;
import mk.ukim.finki.emt.sharedkernel.config.TopicHolder;
import mk.ukim.finki.emt.sharedkernel.events.DomainEvent;

@Getter
public class TourRemoved extends DomainEvent {

    private String guideId;
    private String tourId;

    public TourRemoved(String topic) {
        super(TopicHolder.TOPIC_TOUR_REMOVED);
    }

    public TourRemoved(String guideId, String tourId) {
        super(TopicHolder.TOPIC_TOUR_REMOVED);
        this.guideId = guideId;
        this.tourId = tourId;
    }
}
