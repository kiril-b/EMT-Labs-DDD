package mk.ukim.finki.emt.sharedkernel.events.tours;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;
import mk.ukim.finki.emt.sharedkernel.config.TopicHolder;
import mk.ukim.finki.emt.sharedkernel.events.DomainEvent;

@Getter
public class TourCreated extends DomainEvent {

    private String guideId;
    private String tourId;


    public TourCreated(String topic) {
        super(TopicHolder.TOPIC_TOUR_CREATED);
    }

    @JsonCreator
    public TourCreated(@JsonProperty("guideId") String guideId, @JsonProperty("tourId") String tourId) {
        super(TopicHolder.TOPIC_TOUR_CREATED);
        this.guideId = guideId;
        this.tourId = tourId;
    }
}
